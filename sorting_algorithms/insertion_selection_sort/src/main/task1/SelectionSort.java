package main.task1;

import main.Student;

public class SelectionSort {
    static void selectionSort(Student[] studs) {
        for (var min = 0; min < studs.length - 1; min++) {
            var least = min;
            for (var j = min + 1; j < studs.length; j++)
                if (compare(studs[j], studs[least]) == 1)
                    least = j;
            swap(studs, min, least);
        }
    }

    public static int compare(Student s1, Student s2) {
        char surname1[] = s1.getSurname().toCharArray();
        char name1[] = s1.getName().toCharArray();
        char surname2[] = s2.getSurname().toCharArray();
        char name2[] = s2.getName().toCharArray();
        var pos = 0;
        if (s1.getForm().equals("budget") && s2.getForm().equals("contract"))
            return 1;
        else if (s2.getForm().equals("budget") && s1.getForm().equals("contract"))
            return -1;
        else {
            while (pos != surname1.length && pos != surname2.length || pos != name1.length && pos != name2.length)
                if (surname1[pos] < surname2[pos] || name1[pos] < name2[pos])
                    return 1;
                else if (surname1[pos] > surname2[pos] || name1[pos] > name2[pos])
                    return -1;
                else
                    pos++;
            return 0;
        }
    }

    private static void swap(Student[] studs, int i, int j) {
        var temp = studs[i];
        studs[i] = studs[j];
        studs[j] = temp;
    }
}