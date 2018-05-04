package main.task1;

import main.Student;

import java.util.Arrays;
import java.util.List;

class ArrayOfStudents {
    static Student[] create(List<String[]> list) {
        int numStudents = 0;
        Student[] students = new Student[list.size()];

        for (String[] line : list) {
            students[numStudents] = new Student();
            numStudents += writeStudInfo(students[numStudents], line);
        }

        if (numStudents != list.size())
            students = copyOf(students, numStudents);

        return students;
    }

    private static Student[] copyOf(Student[] students, int numStudents) {
        Student[] buf_students = new Student[numStudents];
        System.arraycopy(students, 0, buf_students, 0, numStudents);
        return buf_students;
    }

    private static int writeStudInfo(Student student, String[] line) {
        if (line.length != student.getClass().getDeclaredFields().length - 2) {
            System.err.println("Error: the line  \"" + Arrays.toString(line)
                    + "\" not completed");
            return 0;
        }

        if (Student.isValidSurName(line[0].trim()) &&
                Student.isValidSurName(line[1].trim()) &&
                Student.isValidForm(line[2].trim())) {
            student.setName(line[0].trim());
            student.setSurname(line[1].trim());
            student.setForm(line[2].trim());
            return 1;
        }

        return 0;
    }
}