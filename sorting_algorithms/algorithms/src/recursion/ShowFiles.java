package recursion;

import java.io.File;

class ShowFiles {
    private static void printFileNames(String path) {
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("Directory :  " + f.getName());
                printFileNames(f.getPath());
            } else
                System.out.println("File :  " + f.getName());
        }
    }

    public static void main(String[] args) {
        printFileNames("/home/dima/Design_Patterns/patterns/data");
    }
}