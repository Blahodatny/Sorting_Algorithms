package recursion;

class Fibonacci {
    private static int fibonacci(int n) {
        return n < 0 ? 0 : n == 0 || n == 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        var number = 6;
        System.out.println(number + "-number of Fibonacci sequence is " + fibonacci(number));
    }
}