package assistant;

import java.util.Arrays;
import java.util.Random;

public class ArrayAssistant {
    public static void print(int[] a, String message) {
        System.out.println(message);
        Arrays.stream(a).forEach(anA -> System.out.printf("% -5d", anA));
        System.out.println();
    }

    public static void fillRandom(int[] a, int range) {
        fillRandom(a, 0, range);
    }

    private static void fillRandom(int[] a, int from, int to) {
        var r = new Random();
        Arrays.setAll(a, i -> r.nextInt(to - from + 1) + from);
    }

    public static void swap(int[] ar, int i, int j) {
        var temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}