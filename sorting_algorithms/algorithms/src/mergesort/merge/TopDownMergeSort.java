package mergesort.merge;

import assistant.ArrayAssistant;

import java.util.Arrays;

import static mergesort.merge.Merge.merge;

public class TopDownMergeSort {
    private static final int N = 15;

    public static void main(String[] args) {

        int[] arr = new int[N];
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
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private static int[] mergeSort2(int a[]) {
        if (a.length > 1) {
            // Split the array in half in two parts
            int[] b = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] c = Arrays.copyOfRange(a, b.length, a.length);
            return twoWayMerge(mergeSort2(b), mergeSort2(c));
        } else
            return a;
    }

    static int[] twoWayMerge(int[] leftArray, int[] rightArray) {
        int iLeft = 0;
        int iRight = 0;
        int iResult = 0;
        int[] result = new int[leftArray.length + rightArray.length];
        while (iLeft < leftArray.length && iRight < rightArray.length)
            if (leftArray[iLeft] <= rightArray[iRight])
                result[iResult++] = leftArray[iLeft++];
            else
                result[iResult++] = rightArray[iRight++];
        System.arraycopy(leftArray, iLeft, result, iResult, leftArray.length - iLeft);
        System.arraycopy(rightArray, iRight, result, iResult, rightArray.length - iRight);
        return result;
    }
}