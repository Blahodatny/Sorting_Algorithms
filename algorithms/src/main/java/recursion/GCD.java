package recursion;

class GCD {
    public static void main(String[] args) {
        var a = 14;
        var b = 21;
        var g = gdc(a, b);
        System.out.println("gdc (" + a + ", " + b + ") = " + g);
    }

    private static int gdc(int a, int b) {
        return b == 0 ? a : gdc(b, a % b);
    }
}