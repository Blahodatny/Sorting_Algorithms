package quicksort.sorts;

import assistant.ArrayAssistant;
import quicksort.CheckSort;

import static quicksort.Partition.partition;

class MedianOf3QuickSort {

    private final static int N = 30;

    public static void main(String[] args) {
        CheckSort.check(N, MedianOf3QuickSort::quickSort);
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            int pivot = medianOf3(ar, lo, hi);
            ArrayAssistant.print(ar, "After median of 3");
            System.out.println("pivot = " + pivot);
            int q = partition(ar, lo + 1, hi - 1);
            quickSort(ar, lo, q - 1);
            quickSort(ar, q + 1, hi);
        }
    }

    private static int medianOf3(int[] data, int left, int right) {
        int center = (left + right) / 2;

        // order left & center
        if (data[left] > data[center])
            ArrayAssistant.swap(data, left, center);

        // order left & right
        if (data[left] > data[right])
            ArrayAssistant.swap(data, left, right);

        // order center & right
        if (data[center] > data[right])
            ArrayAssistant.swap(data, center, right);

        ArrayAssistant.swap(data, center, right - 1); // put pivot on right
        return data[right - 1]; // return median value
    }
}