package mergesort.merge;

import assistant.ArrayAssistant;

import static mergesort.merge.Merge.merge;

class BottomUpMergeSort {
    private final static int N = 20;

    public static void main(String[] args) {
        var arr = new int[N];
        ArrayAssistant.fillRandom(arr, 100);
        ArrayAssistant.print(arr, "Before merging");
        bottomUpMergeSort(arr);
        ArrayAssistant.print(arr, "After merging");
    }

    // Bottom-up merge sort
    private static void bottomUpMergeSort(int[] array) {
        var step = 1;
        while (step < array.length) {
            var l = 0;
            while (l < array.length - step) {
                var m = l + step - 1;
                var r = (l + 2 * step - 1) < (array.length - 1) ?
                        (l + 2 * step - 1) : array.length - 1;
                merge(array, l, m, r);
                l += step * 2;
            }
            step = step * 2;
        }
    }
}