package recursion;

class Fibonacci {
    public static void main(String[] args) {
        var number = 10;
        System.out.println(number + "-number of Fibonacci sequance is   "
                + fibonacci(number));
    }

    private static int fibonacci(int n) {
        // recursive step
        return n == 0 || n == 1 ? n : fibonacci(n - 1) + fibonacci(n - 2); // base cases
    }
}