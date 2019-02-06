package mergesort;

import assistant.ArrayAssistant;

import java.util.Arrays;

import static mergesort.Merge.merge;

class TopDownMergeSort {
    private static void mergeSort(int a[]) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            var m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            Merge.merge(a, l, m, r);
        }
    }

    private static int[] twoWayMerge(int a[]) {
        if (a.length > 1) {
            // Split the array in half in two parts
            var b = Arrays.copyOfRange(a, 0, a.length / 2);
            var c = Arrays.copyOfRange(a, b.length, a.length);
            return Merge.merge(twoWayMerge(b), twoWayMerge(c));
        } else
            return a;
    }

    public static void main(String[] args) {
        var arr = new int[]{38, 27, 43, 3, 9, 82, 10};
//        ArrayAssistant.fillRandom(arr, 1000);
        ArrayAssistant.print(arr, "Before sorting");

        mergeSort(arr);
        ArrayAssistant.print(arr, "After sorting");
        System.out.println(System.lineSeparator());

        ArrayAssistant.fillRandom(arr, 1000);
        ArrayAssistant.print(arr, "Before sorting");
        arr = twoWayMerge(arr);
        ArrayAssistant.print(arr, "After sorting");
    }
}