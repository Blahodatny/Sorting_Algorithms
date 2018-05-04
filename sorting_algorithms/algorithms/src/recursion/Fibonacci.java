package recursion;

class Fibonacci {
    public static void main(String[] args) {
        int number = 10;
        System.out.println(number + "-number of Fibonacci sequance is   "
                + fibonacci(number));
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n; // base cases
        else
            return fibonacci(n - 1) + fibonacci(n - 2); // recursive step
    }
}