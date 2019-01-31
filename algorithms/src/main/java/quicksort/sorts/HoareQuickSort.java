package quicksort.sorts;

import assistant.ArrayAssistant;
import quicksort.CheckSort;

class HoareQuickSort {
    private final static int N = 20;

    public static void main(String[] args) {
        CheckSort.check(N, HoareQuickSort::quickSort);
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] ar, int p, int r) {
        int q;
        if (p < r) {
            q = partition(ar, p, r);
            quickSort(ar, p, q);
            quickSort(ar, q + 1, r);
        }
    }

    // Hoare Partition
    private static int partition(int[] ar, int p, int r) {
        var pivot = ar[p];
        var left = p - 1;
        var right = r + 1;

        while (true) {
            // decrement the r pointer until you meet the pivot
            while (left <= --right && ar[right] > pivot) ;
            // increment the p pointer until you meet the pivot
            while (++left <= right && ar[left] < pivot) ;

            // if the pointers have crossed, swap the items
            if (left < right) // swap array[left] with array[right]
                ArrayAssistant.swap(ar, left, right);
            else
                return right;
        }
    }

    // Hoare Improved Partition
    public static int partitionImpr(int[] ar, int p, int r) {
        var pivot = ar[p];
        var left = p;
        var right = r + 1;

        while (true) {
            // decrement the r pointer until you meet the pivot
            while (left < --right && ar[right] > pivot) ;
            // increment the p pointer until you meet the pivot
            while (++left < right && ar[left] < pivot) ;

            // if the pointers have crossed, swap the items
            if (left >= right)
                break;
            ArrayAssistant.swap(ar, left, right);
        }
        // swap pivot and the end of less part
        ArrayAssistant.swap(ar, right, p);
        return left;
    }
}