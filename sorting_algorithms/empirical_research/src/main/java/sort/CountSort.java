package sort;

public class CountSort {
    public static int[] countSort(int[] read) { // 2 4 2 1 9 5
        int[] array = new int[read.length];
        int min = read[0];
        int max = read[0];
        for (int i = 1; i < read.length; i++)
            if (read[i] < min)
                min = read[i]; // 1
            else if (read[i] > max)
                max = read[i]; // 9

        int[] counts = new int[max - min + 1]; // 9 - 1 + 1 == 9

        for (int aRead : read)
            counts[aRead - min]++; // counts[9] = {1, 2, 0, 1, 1, 0, 0, 0, 1};

        counts[0]--; // counts[9] = {0, 2, 0, 1, 1, 0, 0, 0, 1};
        // counts[0] == 0, counts[1] == 2
        for (int i = 1; i < counts.length; i++)
            counts[i] = counts[i] + counts[i - 1]; // counts[9] = {0, 2, 2, 3, 4, 4, 4, 4, 5};

        // i == 5, read[i] == 5, counts[5 - 1]-- == 4, if was --(counts[read[i] - min]) it would equal 3
        for (int i = read.length - 1; i >= 0; i--)
            array[counts[read[i] - min]--] = read[i];
        return array;
    }
}