package recursion;

class HanoiTower {
    public static void main(String[] args) {
        var n = 3;
        hanoi(n, 1, 2, 3);
    }

    private static void hanoi(int nDisks, int src, int dest, int spare) {
        if (nDisks > 1) {
            hanoi(nDisks - 1, src, spare, dest);
            hanoi(1, src, dest, spare);
            hanoi(nDisks - 1, spare, dest, src);
        } else
            System.out.println(src + " -> " + dest);
    }
}