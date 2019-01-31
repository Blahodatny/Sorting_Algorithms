package analysis;

import helpers.FileWorker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Analysis {
    private static final int RANGE = 1_000_000;
    private static final int START = 10_000;

    private static int[] fillRandom(int size, int range) {
        var array = new int[size];
        fillRandom(array, 0, range);
        return array;
    }

    private static void fillRandom(int[] a, int from, int to) {
        var random = new Random();
        Arrays.setAll(a, i -> random.nextInt(to - from + 1) + from);
    }

    private static int countSize(int repeat, int start) {
        for (var i = 0; i < repeat; i++)
            start = i == 0 ? start + 15000 : i == 3 ? start + 50000 : start * 2;
        return start;
    }

    public static double[][] analyze(List<Consumer<int[]>> algorithms, int repeat) {
        var worker = new FileWorker();
        var average = new double[algorithms.size()][repeat];
        var time = new double[repeat][algorithms.size()][repeat];

        for (var i = 0; i < repeat; i++) {
            var size = 10000;
            worker.write("data" + i + ".txt", fillRandom(countSize(repeat, START), RANGE));
            for (var j = 0; j < repeat; j++) {
                var array = worker.read("data" + i + ".txt", size);
                for (var k = 0; k < algorithms.size(); k++) {
                    var start = System.nanoTime();
                    algorithms.get(k).accept(array.clone());
                    time[i][k][j] = (double) (System.nanoTime() - start) / 1_000_000_000;
                }
                size = i == 0 ? size + 15000 : i == 3 ? size + 50000 : size * 2;
            }
        }

        for (var i = 0; i < algorithms.size(); i++)
            for (var j = 0; j < repeat; j++) {
                for (var k = 0; k < repeat; k++)
                    average[i][j] += time[k][i][j];
                average[i][j] /= repeat;
            }

        return average;
    }
}