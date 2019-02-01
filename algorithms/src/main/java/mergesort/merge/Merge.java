package mergesort.merge;

import java.util.stream.IntStream;

class Merge {
    static void merge(int[] arr, int l, int m, int r) {
        var left = IntStream.range(0, m - l + 1).map(i -> arr[l + 1]).toArray();
        var right = IntStream.range(0, r - m).map(i -> arr[m + i + 1]).toArray();

        for (int k = l, i = 0, j = 0; k <= r; k++)
            arr[k] = i == left.length ?
                    right[j++] : j == right.length ?
                    left[i++] : left[i] <= right[j] ?
                    left[i++] : right[j++];
    }
}