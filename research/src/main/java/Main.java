import analysis.Analysis;
import sort.ShellSort;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        var array = Analysis.analyze(Arrays.asList(ShellSort::classic, ShellSort::knuth), 3, 100000);
            for (int j = 0; j < 3; j++)
                System.out.println("Average time of Classic: " + array[0][j]);
    }
}