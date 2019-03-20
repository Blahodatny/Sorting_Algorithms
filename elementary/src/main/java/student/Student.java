package student;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class Student {
    private String name;
    private String surname;
    private String form;

    public Student(String[] info) {
        if (info.length < getClass().getDeclaredFields().length)
            throw new IllegalArgumentException(
                    "The line  \"" + Arrays.toString(info) + "\" not completed"
            );

        if (isValidName(info[0]) && isValidName(info[1]) && isValidForm(info[2])) {
            name = info[0];
            surname = info[1];
            form = info[2];
        } else
            throw new IllegalArgumentException("Some of parameters is not valid");
    }

    private static boolean isValidName(String string) {
        return Character.isUpperCase(string.charAt(0)) &&
                IntStream
                        .range(1, string.length())
                        .allMatch(i -> Character.isAlphabetic(string.charAt(i)));
    }

    private static boolean isValidForm(String form) {
        return Set.of("budget", "contract").contains(form);
    }

    public int compare(Student student) {
        if (form.equals("budget") && student.form.equals("contract"))
            return 1;
        else if (student.form.equals("budget") && form.equals("contract"))
            return -1;
        else {
            var pos = 0;
            var temp1 = surname.toCharArray();
            var temp2 = student.surname.toCharArray();
            while (pos != temp1.length && pos != temp2.length)
                if (temp1[pos] < temp2[pos])
                    return 1;
                else if (temp1[pos] > temp2[pos])
                    return -1;
                else if (++pos == temp1.length &&
                        pos == temp2.length &&
                        temp1 == surname.toCharArray()) {
                    temp1 = name.toCharArray();
                    temp2 = student.name.toCharArray();
                    pos = 0;
                }
            return 0;
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        var student = (Student) o;
        return name.equals(student.name) &&
                surname.equals(student.surname) &&
                form.equals(student.form);
    }

    public int hashCode() {
        return Objects.hash(name, surname, form);
    }

    public String toString() {
        return String.format("%-10s|   %-15s|  %-10s|", name, surname, form);
    }
}