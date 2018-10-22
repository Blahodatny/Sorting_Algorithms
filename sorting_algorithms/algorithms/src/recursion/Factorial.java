package recursion;

import java.util.stream.IntStream;

class Factorial {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 10).forEach(n -> System.out.printf("%n%2d !  =  %d", n, fact(n)));
    }

    private static long fact(int n) {
        return n == 0 ? 1 : n * fact(n - 1);
    }
}