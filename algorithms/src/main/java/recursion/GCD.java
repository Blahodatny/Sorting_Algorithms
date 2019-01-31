package recursion;

class GCD {
    // Greatest Common Divisor
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        var a = 14;
        var b = 21;
        System.out.println("gcd (" + a + ", " + b + ") = " + gcd(a, b));
    }
}