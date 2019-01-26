import helpers.CSV;
import helpers.Converter;
import sort.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        var list = new CSV().readFile("students.csv");
        var studentArray = Converter.toStudentArray(list);
        System.out.println("Selection sort of array\nBefore sorting:");
        Arrays.stream(studentArray).forEach(System.out::println);
        Sort.selection(studentArray);
        System.out.println("\nAfter sorting:");
        Arrays.stream(studentArray).forEach(System.out::println);
    }
}