package main.task1;

import main.CSV;
import main.Student;

import java.nio.file.Paths;
import java.util.Arrays;

import static main.task1.SelectionSort.selectionSort;

class SorterTask1 {
    private static String currentDir = System.getProperty("user.dir") + "/insertion_selection_sort/data";

    public static void main(String[] args) {
        var list = CSV.readCSV(
                Paths.get(currentDir, "students.csv").toString());

        assert list != null;
        Student[] students = null;
        if (!list.isEmpty())
            students = ArrayOfStudents.create(list);

        System.out.println("\nBefore sorting\n");
        printStudents(students);
        assert students != null;
        selectionSort(students);
        System.out.println("\nAfter sorting\n");
        printStudents(students);
    }

    private static void printStudents(Student[] studs) {
        if (studs == null || studs.length == 0) return;
        Arrays.stream(studs).forEach(Student::print);
    }
}