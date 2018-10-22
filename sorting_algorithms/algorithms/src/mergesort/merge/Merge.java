package mergesort.merge;

import java.util.stream.IntStream;

class Merge {
    static void merge(int arr[], int l, int m, int r) {
        var n1 = m - l + 1;
        var n2 = r - m;

        var leftArray = new int[n1];
        int[] rightArray;

        // copy from left subarray
        System.arraycopy(arr, l, leftArray, 0, leftArray.length);
        // copy from right subarray
        rightArray = IntStream.range(0, n2).map(j -> arr[m + j + 1]).toArray();

        for (int k = l, i = 0, j = 0; k <= r; k++) {
            if (i == leftArray.length) {
                arr[k] = rightArray[j++];
                continue;
            }

            if (j == rightArray.length) {
                arr[k] = leftArray[i++];
                continue;
            }

            arr[k] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
        }
    }
}