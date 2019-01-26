package sort;

import student.Student;

public class Sort {
    public static void selection(Student[] students) {
        for (var min = 0; min < students.length - 1; min++) {
            var least = min;
            for (var j = min + 1; j < students.length; j++)
                if (students[j].compare(students[least]) == 1)
                    least = j;
            swap(students, min, least);
        }
    }

//    static Student insertion(Student head) {
//        if (head == null) return null;
//        var temp = head;
//        Student sortedList = null;
//        while (head != null) {
//            for (var cur = head.getNext(); cur != null; cur = cur.getNext())
//                if (compare(cur, temp) == -1)
//                    temp = cur;
//            head = deleteNode(head, temp);
//            sortedList = addFirst(sortedList, temp);
//            temp = head;
//        }
//        return sortedList;
//    }

    private static void swap(Student[] students, int i, int j) {
        var temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}
