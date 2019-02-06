package mergesort;

import assistant.ArrayAssistant;


class BottomUpMergeSort {
    private static void bottomUpMergeSort(int[] array) {
        var step = 1;
        while (step < array.length) {
            var l = 0;
            while (l < array.length - step) {
                var m = l + step - 1;
                var r = (l + 2 * step - 1) < (array.length - 1) ?
                        (l + 2 * step - 1) :
                        array.length - 1;
                Merge.merge(array, l, m, r);
                l += step * 2;
            }
            step *= 2;
        }
    }

    public static void main(String[] args) {
        var arr = new int[20];
        ArrayAssistant.fillRandom(arr, 100);
        ArrayAssistant.print(arr, "Before merging");
        bottomUpMergeSort(arr);
        ArrayAssistant.print(arr, "After merging");
    }
}