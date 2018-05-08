import file_worker.FileWorker;

import java.io.IOException;
import java.util.Random;

import static mergesort.merge.TopDownMergeSort.mergeSort;

class TopDownMergeSort {
    private static String currentDir = System.getProperty("user.dir") + "/empirical_research/src/main/resources/data.txt";
    private static final int SIZE = 1000000;
    private static final int QUANTITY = 6;

    public static void main(String args[]) throws IOException {
        var fa = new FileWorker();
        int[] array;
        var time = new double[QUANTITY];
        var averageTime = new double[QUANTITY];
        final var random = new Random();

        var min = 10000;
        for (var i = 0; i < QUANTITY; i++) {
            for (var j = 0; j < QUANTITY; j++) {

                var buffer = new int[SIZE];
                for (var k = 0; k < min; ++k)
                    buffer[k] = random.nextInt() % 10000;
                fa.write(currentDir, buffer);

                array = fa.read(currentDir, min);

                var startTime = System.nanoTime();
                mergeSort(array, 0, array.length - 1);
                time[j] = (double) (System.nanoTime() - startTime) / 1000000000;
            }
            averageTime[i] = (time[0] + time[1] + time[2] + time[3] + time[4] + time[5]) / 6;
            System.out.printf("The time of %d iteration with %d elements:	%g\n", i, min, averageTime[i]);
            if (i == 0)
                min = min + 15000;
            else if (i == 3)
                min = min + 50000;
            min = min * 2;
        }
//		fa.write(System.getProperty("user.dir") + File.separatorChar + "data" + File.separatorChar + "sortedArray.txt", array);
    }
}