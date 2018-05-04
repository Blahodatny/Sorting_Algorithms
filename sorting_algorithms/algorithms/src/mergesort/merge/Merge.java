package mergesort.merge;

class Merge {
    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // copy from left subarray
        System.arraycopy(arr, l, leftArray, 0, leftArray.length);
        // copy from right subarray
        for (int j = 0; j < rightArray.length; j++)
            rightArray[j] = arr[m + j + 1];

        for (int k = l, i = 0, j = 0; k <= r; k++) {
            if (i == leftArray.length) {
                arr[k] = rightArray[j++];
                continue;
            }

            if (j == rightArray.length) {
                arr[k] = leftArray[i++];
                continue;
            }

            if (leftArray[i] <= rightArray[j])
                arr[k] = leftArray[i++];
            else
                arr[k] = rightArray[j++];
        }
    }
}