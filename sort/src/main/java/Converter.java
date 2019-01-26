import student.Student;
import student.StudentList;

import java.util.List;

public class Converter {
    public static Student[] toStudentArray(List<String[]> list) {
        return list.stream().map(Student::new).toArray(Student[]::new);
    }

    public static StudentList toStudentList(List<String[]> list) {
        var studentList = new StudentList();
        list.stream().map(Student::new).forEach(studentList::add);
        return studentList;
    }
}