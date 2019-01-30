package sort;

import java.util.Arrays;
import java.util.Scanner;

class ElementarySort {
    private static void swap(int[] array, int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void bubble(int[] array) {
        var swapped = true;
        for (var i = 0; i < array.length - 1 && swapped; i++) {
            swapped = false;
            for (var j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
        }
    }

    private static void insertion(int[] array) {
        for (var i = 1; i < array.length; i++) {
            var key = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > key)
                array[j + 1] = array[j--];
            array[j + 1] = key;
        }
    }

    private static void selection(int[] array) {
        for (var i = 0; i < array.length - 1; i++) {
            var min = i;
            for (var j = i + 1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j;
            if (min != i)
                swap(array, i, min);
        }
    }

    public static void main(String... args) {
        var array = new int[]{5, 1, 4, 2, 8};
        System.out.println(Arrays.toString(array));
        switch (new Scanner(System.in).nextByte()) {
            case 1:
                bubble(array);
                break;
            case 2:
                insertion(array);
                break;
            case 3:
                selection(array);
        }
        System.out.println(Arrays.toString(array));
    }
}