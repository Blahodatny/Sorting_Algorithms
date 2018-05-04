package recursion;

class Factorial {
    public static void main(String[] args) {
        for (int n = 0; n <= 10; n++)
            System.out.printf("%n%2d !  =  %d", n, fact(n));
    }

    private static long fact(int n) {
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }
}