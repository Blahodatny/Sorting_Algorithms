package quicksort.sorts;

import assistant.ArrayAssistant;
import quicksort.CheckSort;

import java.util.Random;

import static quicksort.Partition.partition;

class RandomizedQuickSort {
    private final static int N = 20;

    public static void main(String[] args) {
        CheckSort.check(N, RandomizedQuickSort::quickSort);
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static int rand(int lo, int hi) {
        var rn = new Random();
        var n = hi - lo + 1;
        var i = rn.nextInt(n);
        return lo + i;
    }

    private static void quickSort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            var iPivot = rand(lo, hi);
            ArrayAssistant.swap(ar, iPivot, hi);
            var q = partition(ar, lo, hi);
            System.out.println("q =  " + q);
            quickSort(ar, lo, q - 1);
            quickSort(ar, q + 1, hi);
        }
    }
}