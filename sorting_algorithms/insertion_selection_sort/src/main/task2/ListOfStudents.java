package main.task2;

import main.Student;

import java.util.Arrays;
import java.util.List;

import static main.Student.addNode;

class ListOfStudents {
    static Student create(List<String[]> list) {
        Student head = null;
        for (var line : list)
            head = addNode(head, writeStudInfo(line));
        return head;
    }

    private static Student writeStudInfo(String[] line) {
        if (line.length != Student.class.getDeclaredFields().length - 2) {
            System.err.println("Error: the line  \"" + Arrays.toString(line)
                    + "\" not completed");
            return null;
        }

        if (Student.isValidSurName(line[0].trim()) &&
                Student.isValidSurName(line[1].trim()) &&
                Student.isValidForm(line[2].trim())) {
            var student = new Student();
            student.setName(line[0].trim());
            student.setSurname(line[1].trim());
            student.setForm(line[2].trim());
            return student;
        }
        return null;
    }
}