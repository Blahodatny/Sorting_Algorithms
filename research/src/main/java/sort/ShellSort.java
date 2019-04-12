package sort;

import java.util.stream.IntStream;

public class ShellSort {
    private static void sort(int[] array, int gap) {
        for (var i = gap; i < array.length; i++) {
            var key = array[i];
            int j;
            for (j = i; j >= gap && array[j - gap] > key; j -= gap)
                array[j] = array[j - gap];
            array[j] = key;
        }
    }

    public static void classic(int[] array) {
        IntStream.iterate(array.length / 2, gap -> gap > 0, gap -> gap / 2)
                .forEach(gap -> sort(array, gap));
    }

    public static void knuth(int[] array) {
        var gap = 1;
        while (gap < array.length / 3)
            gap = 3 * gap + 1;

        IntStream.iterate(gap, i -> i > 0, i -> i / 3)
                .forEach(i -> sort(array, i));
    }
}