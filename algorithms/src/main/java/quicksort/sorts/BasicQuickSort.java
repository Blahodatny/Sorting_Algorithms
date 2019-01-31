package quicksort.sorts;

import quicksort.CheckSort;

import static quicksort.Partition.partition;

class BasicQuickSort {
    private final static int N = 20;

    public static void main(String[] args) {
        CheckSort.check(N, BasicQuickSort::quickSort);
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            var q = partition(ar, lo, hi);
            quickSort(ar, lo, q - 1);
            quickSort(ar, q + 1, hi);
        }
    }
}