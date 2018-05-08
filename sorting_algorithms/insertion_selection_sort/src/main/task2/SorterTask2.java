package main.task2;

import main.CSV;
import main.Student;

import java.nio.file.Paths;

import static main.task2.InsertionSort.insertionSort;

class SorterTask2 {
    private static String currentDir = System.getProperty("user.dir") + "/insertion_selection_sort/data";

    public static void main(String[] args) {
        var list = CSV.readCSV(
                Paths.get(currentDir, "students.csv").toString());

        assert list != null;
        Student head = null;
        if (!list.isEmpty())
            head = ListOfStudents.create(list);

        System.out.println("\nBefore sorting\n");
        printStudents(head);
        System.out.println("\nAfter sorting\n");
        printStudents(insertionSort(head));
    }

    private static void printStudents(Student head) {
        if (head == null)
            return;
        Student cur = null;
        while (head != null) {
            head.print();
            cur = head;
            head = head.getNext();
        }
        System.out.println("-------------------------------------------");
        while (cur != null) {
            cur.print();
            cur = cur.getPrev();
        }
    }
}