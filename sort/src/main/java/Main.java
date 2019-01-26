import csv.CSV;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        var list = new CSV().readFile("students.csv");
        list.stream().map(Arrays::toString).forEach(System.out::println);
    }
}