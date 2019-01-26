package student;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

public class Student {
    private String name;
    private String surname;
    private String form;

    public Student(String[] info) {
        if (info.length <= this.getClass().getDeclaredFields().length)
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
        return Character.isUpperCase(string.charAt(0))
                && IntStream
                .range(1, string.length())
                .allMatch(i -> Character.isAlphabetic(string.charAt(i)));
    }

    private static boolean isValidForm(String form) {
        return Set.of("budget", "contract").contains(form);
    }
}