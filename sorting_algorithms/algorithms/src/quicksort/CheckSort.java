package quicksort;

import assistant.ArrayAssistant;

import java.util.function.Consumer;

public class CheckSort {
    public static void check(int N, Consumer<int[]> function) {
        int[] array = new int[N];
        ArrayAssistant.fillRandom(array, 100);
        ArrayAssistant.print(array, "Before sorting");
        function.accept(array);
        ArrayAssistant.print(array, "After sorting");
        System.out.println(System.lineSeparator());
    }
}