package main.task2;

import main.Student;

import static main.Student.addFirst;
import static main.Student.deleteNode;
import static main.task1.SelectionSort.compare;

class InsertionSort {
    static Student insertionSort(Student head) {
        if (head == null) return null;
        var temp = head;
        Student sortedList = null;
        while (head != null) {
            for (var cur = head.getNext(); cur != null; cur = cur.getNext())
                if (compare(cur, temp) == -1)
                    temp = cur;
            head = deleteNode(head, temp);
            sortedList = addFirst(sortedList, temp);
            temp = head;
        }
        return sortedList;
    }
}