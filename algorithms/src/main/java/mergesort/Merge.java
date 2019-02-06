package mergesort;

import assistant.ArrayAssistant;

import java.util.Arrays;
import java.util.stream.IntStream;

class Merge {
    private static void merge(int[] result, int[] left, int[] right, int start, int end) {
        for (int i = 0, j = 0, k = start; k <= end; k++)
            result[k] = i == left.length ? right[j++] :
                    j == right.length ? left[i++] :
                            left[i] <= right[j] ? left[i++] :
                                    right[j++];
    }

    static void merge(int[] arr, int l, int m, int r) {
        var left = IntStream.rangeClosed(0, m - l).map(i -> arr[l + i]).toArray();
        var right = IntStream.range(0, r - m).map(i -> arr[m + i + 1]).toArray();
        merge(arr, left, right, l, r);
    }

    static int[] merge(int[] left, int[] right) {
        var result = new int[left.length + right.length];
        merge(result, left, right, 0, result.length - 1);
        return result;
    }

    private static int[] abstractInPlaceMerge(int[] left, int[] right) {
        var aux = new int[left.length + right.length];
        var a = new int[left.length + right.length];

        int i, j, k;
        for (i = 0, k = 0; i < left.length; i++, k++)
            aux[i] = left[i];

        for (j = right.length - 1; k < aux.length; k++, j--)
            aux[k] = right[j];

        i = 0;
        j = aux.length - 1;
        for (k = 0; k < aux.length; k++)
            a[k] = aux[j] < aux[i] ? aux[j--] : aux[i++];
        return a;
    }

    public static void main(String[] args) {
        var arr1 = new int[12];
        ArrayAssistant.fillRandom(arr1, 100);
        Arrays.sort(arr1);
        ArrayAssistant.print(arr1, "Array1 before merging");

        var arr2 = new int[7];
        ArrayAssistant.fillRandom(arr2, 100);
        Arrays.sort(arr2);
        ArrayAssistant.print(arr2, "Array2 before merging");

        ArrayAssistant.print(
                abstractInPlaceMerge(arr1, arr2),
                "After abstract-in-place merging arr1 and arr2"
        );
    }
}