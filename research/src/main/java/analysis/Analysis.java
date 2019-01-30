package analysis;

import helpers.FileWorker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Analysis {
    private static int[] fillRandom(int size, int range) {
        var array = new int[size];
        fillRandom(array, 0, range);
        return array;
    }

    private static void fillRandom(int[] a, int from, int to) {
        var random = new Random();
        Arrays.setAll(a, i -> random.nextInt(to - from + 1) + from);
    }

    public static double[][] analyze(List<Consumer<int[]>> algorithms, int repeat, int size) {
        var worker = new FileWorker();
        var average = new double[algorithms.size()][repeat];
        var time = new double[repeat][algorithms.size()][repeat];

        var min = 10000;
        for (var i = 0; i < repeat; i++) {
            worker.write("data" + i + ".txt", fillRandom(size, min));
            for (var j = 0; j < repeat; j++) {
                var array = worker.read("data" + i + ".txt", min);
                for (var k = 0; k < algorithms.size(); k++) {
                    var start = System.nanoTime();
                    algorithms.get(k).accept(array);
                    time[i][k][j] = (double) (System.nanoTime() - start) / 1000000000;
                }
                min = i == 0 ? min + 15000 : i == 3 ? min + 50000 : min * 2;
            }
            min = 10000;
        }

        System.out.println(Arrays.deepToString(time));

        for (var i = 0; i < algorithms.size(); i++)
            for (var j = 0; j < repeat; j++) {
                for (var k = 0; k < repeat; k++)
                    average[i][j] += time[k][i][j];
                average[i][j] /= repeat;
            }

        return average;
    }
}