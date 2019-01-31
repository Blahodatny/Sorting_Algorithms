package recursion;

import assistant.ArrayAssistant;

class ReverseArray {
    private static final int N = 10;

    private enum Method {
        Iterative, Recursive
    }

    private static void reverse(int[] array, Method m) {
        switch (m) {
            case Iterative:
                for (int i = 0, mid = array.length >> 1, j = array.length - 1; i < mid; i++, j--)
                    ArrayAssistant.swap(array, i, j);
                break;
            case Recursive:
                reverse(array, 0, array.length - 1);
                break;
            default:
                System.out.println("None method to reverse array");
        }
    }

    private static void reverse(int[] array, int i, int j) {
        if (i < j) {
            ArrayAssistant.swap(array, i, j);
            reverse(array, i + 1, j - 1);
        }
    }

    public static void main(String[] args) {
        var ar = new int[N];
        ArrayAssistant.fillRandom(ar, 100);
        ArrayAssistant.print(ar, "Initial array: ");

        System.out.println("Iterative reverse array");
        reverse(ar, Method.Iterative);
        ArrayAssistant.print(ar, "Reverse array: ");

        System.out.println("Recursive reverse array");
        reverse(ar, Method.Recursive);
        ArrayAssistant.print(ar, "Reverse array: ");
    }
}