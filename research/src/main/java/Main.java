import helpers.FileWorker;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        new FileWorker().write("data.txt", new int[]{89, 67, 45});
        System.out.println(Arrays.toString(new FileWorker().read("data.txt", 3)));
    }
}
