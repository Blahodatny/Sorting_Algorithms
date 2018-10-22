package mergesort.merge;

import assistant.ArrayAssistant;

import java.util.Arrays;

import static mergesort.merge.Merge.merge;

public class TopDownMergeSort {
    private static final int N = 15;

    public static void main(String[] args) {

        var arr = new int[N];
        ArrayAssistant.fillRandom(arr, 1000);
        ArrayAssistant.print(arr, "Before sorting");

        mergeSort1(arr);
        ArrayAssistant.print(arr, "After sorting");
        System.out.println(System.lineSeparator());

        ArrayAssistant.fillRandom(arr, 1000);
        ArrayAssistant.print(arr, "Before sorting");
        arr = mergeSort2(arr);
        ArrayAssistant.print(arr, "After sorting");

    }

    private static void mergeSort1(int a[]) {
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            var m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private static int[] mergeSort2(int a[]) {
        if (a.length > 1) {
            // Split the array in half in two parts
            var b = Arrays.copyOfRange(a, 0, a.length / 2);
            var c = Arrays.copyOfRange(a, b.length, a.length);
            return twoWayMerge(mergeSort2(b), mergeSort2(c));
        } else
            return a;
    }

    private static int[] twoWayMerge(int[] leftArray, int[] rightArray) {
        var iLeft = 0;
        var iRight = 0;
        var iResult = 0;
        var result = new int[leftArray.length + rightArray.length];
        while (iLeft < leftArray.length && iRight < rightArray.length)
            result[iResult++] = leftArray[iLeft] <= rightArray[iRight] ? leftArray[iLeft++] : rightArray[iRight++];
        System.arraycopy(leftArray, iLeft, result, iResult, leftArray.length - iLeft);
        System.arraycopy(rightArray, iRight, result, iResult, rightArray.length - iRight);
        return result;
    }
}