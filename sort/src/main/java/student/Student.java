package student;

import java.util.Set;
import java.util.stream.IntStream;

public class Student {
    private String name;
    private String surname;
    private String form;

    public static boolean isValidName(String string) {
        return Character.isUpperCase(string.charAt(0))
                && IntStream
                .range(1, string.length())
                .allMatch(i -> Character.isAlphabetic(string.charAt(i)));
    }

    public static boolean isValidForm(String form) {
        return Set.of("budget", "contract").contains(form);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}