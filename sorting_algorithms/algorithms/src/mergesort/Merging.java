package mergesort;

import assistant.ArrayAssistant;

import java.util.Arrays;

class Merging {
    private final static int N1 = 12;
    private final static int N2 = 7;

    public static void main(String[] args) {
        int[] arr1 = new int[N1];
        ArrayAssistant.fillRandom(arr1, 100);
        Arrays.sort(arr1);
        ArrayAssistant.print(arr1, "Array1 before merging");

        int[] arr2 = new int[N2];
        ArrayAssistant.fillRandom(arr2, 100);
        Arrays.sort(arr2);
        ArrayAssistant.print(arr2, "Array2 before merging");

        System.out.println(System.lineSeparator());

        int[] arrTwoWayMerging = twoWayMerge(arr1, arr2);
        ArrayAssistant.print(arrTwoWayMerging,
                "After two-way merging arr1 and arr2");
        System.out.println(System.lineSeparator());

        int[] arrAbstractInPlace = abstractInPlaceMerge(arr1, arr2);
        ArrayAssistant.print(arrAbstractInPlace,
                "After abstract-in-place merging arr1 and arr2");
        System.out.println(System.lineSeparator());

    }

    static int[] twoWayMerge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < result.length; k++) {
            if (j == rightArray.length) {
                result[k] = leftArray[i++];
                continue;
            }

            if (i == leftArray.length) {
                result[k] = rightArray[j++];
                continue;
            }

            if (leftArray[i] <= rightArray[j])
                result[k] = leftArray[i++];
            else
                result[k] = rightArray[j++];
        }
        return result;
    }

    private static int[] abstractInPlaceMerge(int[] leftArray, int[] rightArray) {
        int[] aux = new int[leftArray.length + rightArray.length];
        int[] a = new int[leftArray.length + rightArray.length];

        int i, j, k;
        for (i = 0, k = 0; i < leftArray.length; i++, k++)
            aux[i] = leftArray[i];

        for (j = rightArray.length - 1; k < aux.length; k++, j--)
            aux[k] = rightArray[j];

        i = 0;
        j = aux.length - 1;
        for (k = 0; k < aux.length; k++)
            if (aux[j] < aux[i])
                a[k] = aux[j--];
            else
                a[k] = aux[i++];
        return a;
    }
}