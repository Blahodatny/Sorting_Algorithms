package recursion;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

class ShowFiles {
    private static void printFolder(String path) {
        printFolder(path, "-");
    }

    private static void printFolder(String path, String separator) {
        Arrays
                .stream(Objects.requireNonNull(new File(path).listFiles()))
                .forEach(item -> {
                    System.out.print(separator);
                    if (item.isDirectory()) {
                        System.out.println("Directory:  " + item.getName());
                        printFolder(item.getPath(), separator + "-");
                    } else
                        System.out.println("File:  " + item.getName());
                });
    }

    public static void main(String[] args) {
        printFolder("./elementary/src/main/");
    }
}