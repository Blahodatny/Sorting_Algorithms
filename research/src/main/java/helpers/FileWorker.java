package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FileWorker {
    private File getFile(String file) {
        return new File("./research/src/main/resources/" + file);
    }

    public void write(String fileName, int[] array) {
        try {
            var file = getFile(fileName);
            if (!file.exists())
                System.out.println(file.createNewFile());
            var writer = new PrintWriter(file);
            IntStream
                    .range(0, array.length)
                    .forEach(i -> writer.print(array[i] + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] read(String fileName, int length) {
        var array = new int[length];
        try {
            var scanner = new Scanner(getFile(fileName));
            for (var i = 0; i < length; i++)
                array[i] = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }
}