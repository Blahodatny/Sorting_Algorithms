package helpers;

import student.Node;
import student.Student;
import student.StudentList;

import java.util.List;

import static java.util.Arrays.stream;

public class Helper {
    public static Student[] convertToStudentArray(List<String[]> list) {
        return list.stream().map(Student::new).toArray(Student[]::new);
    }

    public static void print(Student[] array) {
        stream(array).forEach(System.out::println);
    }

    public static Node convertToStudentList(List<String[]> list) {
        var head = new Node(null, new Student(list.remove(0)), null);
        list.forEach(strings -> StudentList.addAfter(
                head,
                new Student(strings)
        ));
        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.println(head.getItem());
            head = head.getNext();
        }
    }
}