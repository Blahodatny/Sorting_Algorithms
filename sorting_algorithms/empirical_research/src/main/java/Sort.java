import file_worker.FileWorker;

import java.io.IOException;
import java.util.Random;

import static sort.CountSort.countSort;
import static sort.InsertionSort.insertionSort;

class Sort {
    private static String currentDir = System.getProperty("user.dir") + "/empirical_research/src/main/resources/data.txt";
    private static final int SIZE = 1000000;
    private static final int QUANTITY = 6;

    public static void main(String args[]) throws IOException {
        FileWorker fa = new FileWorker();
        int[] array;
        double[] timeCount = new double[QUANTITY];
        double[] timeInsert = new double[QUANTITY];
        double[] averageTimeCount = new double[QUANTITY];
        double[] averageTimeInsert = new double[QUANTITY];
        final Random random = new Random();

        int min = 10000;
        for (int i = 0; i < QUANTITY; i++) {
            for (int j = 0; j < QUANTITY; j++) {

                int[] buffer = new int[SIZE];
                for (int k = 0; k < min; k++)
                    buffer[k] = random.nextInt(100);
                fa.write(currentDir, buffer);

                array = fa.read(currentDir, min);

                long startTime = System.nanoTime();
                System.out.println(countSort(array)[0]);
                timeCount[j] = (double) (System.nanoTime() - startTime) / 1000000000;

                startTime = System.nanoTime();
                insertionSort(array);
                timeInsert[j] = (double) (System.nanoTime() - startTime) / 1000000000;
            }
            averageTimeCount[i] = (timeCount[0] + timeCount[1] + timeCount[2] + timeCount[3] + timeCount[4] + timeCount[5]) / 6;
            System.out.printf("The time of Counting Sort at %d iteration with %d elements:	%g\n", i, min, averageTimeCount[i]);

            averageTimeInsert[i] = (timeInsert[0] + timeInsert[1] + timeInsert[2] + timeInsert[3] + timeInsert[4] + timeInsert[5]) / 6;
            System.out.printf("The time of Insertion Sort at %d iteration with %d elements:	%g\n\n", i, min, averageTimeInsert[i]);
            if (i == 0)
                min = min + 15000;
            else if (i == 3)
                min = min + 50000;
            min = min * 2;
        }
//		fa.write(System.getProperty("user.dir") + File.separatorChar + "data" + File.separatorChar + "sortedArray.txt", array);
    }
}