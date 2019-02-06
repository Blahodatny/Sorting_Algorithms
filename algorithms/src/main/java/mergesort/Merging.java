package mergesort;

import assistant.ArrayAssistant;

import java.util.Arrays;

import static mergesort.Merge.abstractInPlaceMerge;

class Merging {
    public static void main(String[] args) {
        var arr1 = new int[12];
        ArrayAssistant.fillRandom(arr1, 100);
        Arrays.sort(arr1);
        ArrayAssistant.print(arr1, "Array1 before merging");

        var arr2 = new int[7];
        ArrayAssistant.fillRandom(arr2, 100);
        Arrays.sort(arr2);
        ArrayAssistant.print(arr2, "Array2 before merging");

        System.out.println(System.lineSeparator());

        var arrTwoWayMerging = Merge.merge(arr1, arr2);
        ArrayAssistant.print(arrTwoWayMerging,
                "After two-way merging arr1 and arr2");
        System.out.println(System.lineSeparator());

        var arrAbstractInPlace = abstractInPlaceMerge(arr1, arr2);
        ArrayAssistant.print(arrAbstractInPlace,
                "After abstract-in-place merging arr1 and arr2");
        System.out.println(System.lineSeparator());

    }
}