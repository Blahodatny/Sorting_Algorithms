import student.Student;

import java.util.List;

public class StudentArray {
    public static Student[] create(List<String[]> list) {
        return list.stream().map(Student::new).toArray(Student[]::new);
    }
}