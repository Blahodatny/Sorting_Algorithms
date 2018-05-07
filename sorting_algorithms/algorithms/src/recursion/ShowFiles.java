package recursion;

import java.io.File;
import java.util.Arrays;

class ShowFiles {
    private static void printFileNames(String path) {
        File[] files = new File(path).listFiles();
        assert files != null;
        Arrays.stream(files).forEach(f -> {
            if (f.isDirectory()) {
                System.out.println("Directory :  " + f.getName());
                printFileNames(f.getPath());
            } else
                System.out.println("File :  " + f.getName());
        });
    }

    public static void main(String[] args) {
        printFileNames("/home/dima/Design_Patterns/patterns/data");
    }
}