package sort;

public class InsertionSort {
    public static void insertionSort(int[] read) {
        int temp;
        for (var i = 1; i < read.length; i++)
            for (var j = i; j > 0; j--)
                if (read[j] < read[j - 1]) {
                    temp = read[j];
                    read[j] = read[j - 1];
                    read[j - 1] = temp;
                }
    }
}