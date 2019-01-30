package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Objects.requireNonNull;

public class FileWorker {
    private File getFile(String file) {
        return new File(requireNonNull(
                getClass().getClassLoader().getResource(file)
        ).getFile());
    }

    public void write(String file, int[] array) {
        try (var writer = new PrintWriter(getFile(file))) {
            IntStream
                    .range(0, array.length)
                    .forEach(i -> writer.print(array[i] + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] read(String file, int length) {
        var array = new int[length];
        try {
            var scanner = new Scanner(getFile(file));
            var i = 0;
            while (scanner.hasNext())
                array[i++] = scanner.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }
}