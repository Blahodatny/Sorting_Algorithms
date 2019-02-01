import analysis.Analysis;
import sort.ShellSort;

import java.util.Arrays;

class Main {
    public static void main(String... args) {
            ShellSort.classic(new int[]{4, 6, 1, 17, 5, -9, 0 , 45 , 6, 7, 45});
        System.out.println(
                Arrays.deepToString(
                        Analysis.analyze(
                                Arrays.asList(ShellSort::classic, ShellSort::knuth),
                                10)
                )
        );
    }
}