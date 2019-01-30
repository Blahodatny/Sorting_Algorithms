package sort;

public class ShellSort {
    public static void classic(int[] array) {
        for (var gap = array.length / 2; gap > 0; gap /= 2)
            for (var i = gap; i < array.length; i++) {
                var key = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > key; j -= gap)
                    array[j] = array[j - gap];
                array[j] = key;
            }
    }

    public static void knuth(int[] array) {
        var gap = 1;
        while (gap < array.length / 3)
            gap = 3 * gap + 1;

        for (; gap > 0; gap = -gap / 3)
            for (var i = gap; i < array.length; i++)
                for (var j = i; j > 0 && array[j - gap] > array[j]; j -= gap) {
                    var temp = array[j];
                    array[j] = array[j - gap];
                    array[j - gap] = temp;
                }
    }
}