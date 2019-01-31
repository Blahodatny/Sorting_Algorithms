import analysis.Analysis;
import sort.ShellSort;

import java.util.Arrays;

class Main {
    public static void main(String... args) {
        System.out.println(
                Arrays.deepToString(
                        Analysis.analyze(
                                Arrays.asList(ShellSort::classic, ShellSort::knuth),
                                10)
                )
        );
    }
}