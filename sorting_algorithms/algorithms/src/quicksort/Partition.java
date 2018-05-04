package quicksort;

import assistant.ArrayAssistant;

public class Partition {
    // Lumoto partition
    public static int partition(int[] ar, int lo, int hi) {
        int pivot = ar[hi];
        int i = lo - 1;
        for (int j = lo; j <= hi - 1; j++)
            if (ar[j] <= pivot) {
                i++;
                ArrayAssistant.swap(ar, i, j);
            }
        ArrayAssistant.swap(ar, i + 1, hi);
        return i + 1;
    }
}