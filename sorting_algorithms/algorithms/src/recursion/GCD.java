package recursion;

class GCD {
    public static void main(String[] args) {
        int a = 14;
        int b = 21;
        int g = gdc(a, b);
        System.out.println("gdc (" + a + ", " + b + ") = " + g);
    }

    private static int gdc(int a, int b) {
        if (b == 0)
            return a;
        else
            return gdc(b, a % b);
    }
}