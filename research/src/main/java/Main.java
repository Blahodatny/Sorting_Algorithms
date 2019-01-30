import analysis.Analysis;
import sort.ShellSort;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        System.out.println(
                Arrays.deepToString(
                        Analysis
                                .analyze(
                                        Arrays.asList(ShellSort::classic, ShellSort::knuth),
                                        3,
                                        100000)
                )
        );
    }
}