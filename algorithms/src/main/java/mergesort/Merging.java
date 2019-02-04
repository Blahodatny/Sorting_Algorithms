package mergesort;

import assistant.ArrayAssistant;

import java.util.Arrays;

class Merging {
    private final static int N1 = 12;
    private final static int N2 = 7;

    private static int[] twoWayMerge(int[] leftArray, int[] rightArray) {
        var result = new int[leftArray.length + rightArray.length];
        for (int i = 0, j = 0, k = 0; k < result.length; k++)
            result[k] = j == rightArray.length
                    ? leftArray[i++] : i == leftArray.length
                    ? rightArray[j++] : leftArray[i] <= rightArray[j]
                    ? leftArray[i++] : rightArray[j++];
        return result;
    }

    private static int[] abstractInPlaceMerge(int[] leftArray, int[] rightArray) {
        var aux = new int[leftArray.length + rightArray.length];
        var a = new int[leftArray.length + rightArray.length];

        int i, j, k;
        for (i = 0, k = 0; i < leftArray.length; i++, k++)
            aux[i] = leftArray[i];

        for (j = rightArray.length - 1; k < aux.length; k++, j--)
            aux[k] = rightArray[j];

        i = 0;
        j = aux.length - 1;
        for (k = 0; k < aux.length; k++)
            a[k] = aux[j] < aux[i] ? aux[j--] : aux[i++];
        return a;
    }

    public static void main(String[] args) {
        var arr1 = new int[N1];
        ArrayAssistant.fillRandom(arr1, 100);
        Arrays.sort(arr1);
        ArrayAssistant.print(arr1, "Array1 before merging");

        var arr2 = new int[N2];
        ArrayAssistant.fillRandom(arr2, 100);
        Arrays.sort(arr2);
        ArrayAssistant.print(arr2, "Array2 before merging");

        System.out.println(System.lineSeparator());

        var arrTwoWayMerging = twoWayMerge(arr1, arr2);
        ArrayAssistant.print(arrTwoWayMerging,
                "After two-way merging arr1 and arr2");
        System.out.println(System.lineSeparator());

        var arrAbstractInPlace = abstractInPlaceMerge(arr1, arr2);
        ArrayAssistant.print(arrAbstractInPlace,
                "After abstract-in-place merging arr1 and arr2");
        System.out.println(System.lineSeparator());

    }
}