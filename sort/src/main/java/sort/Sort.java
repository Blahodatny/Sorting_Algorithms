package sort;

import student.Node;
import student.Student;

import static student.StudentList.addFirst;
import static student.StudentList.remove;

public class Sort {
    public static void selection(Student[] students) {
        for (var min = 0; min < students.length - 1; min++) {
            var least = min;
            for (var j = min + 1; j < students.length; j++)
                if (students[j].compare(students[least]) == 1)
                    least = j;
            if (least != min)
                swap(students, min, least);
        }
    }

    public static Node insertion(Node head) {
        if (head == null) return null;
        var temp = head;
        Node sortedList = null;
        while (head != null) {
            for (var current = head.getNext(); current != null; current = current.getNext())
                if (current.getItem().compare(temp.getItem()) == 1)
                    temp = current;
            var node = temp.getItem();
            head = remove(head, node);
            sortedList = addFirst(sortedList, node);
            temp = head;
        }
        return sortedList;
    }

    private static void swap(Student[] students, int i, int j) {
        var temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}