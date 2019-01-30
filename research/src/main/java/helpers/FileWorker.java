package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class FileWorker {
    private File getFile(String file) throws FileNotFoundException {
        return new File(requireNonNull(
                getClass().getClassLoader().getResource(file)
        ).getFile());
    }

    public void write(String file, int[] array) {
        try {
            var stream = new FileOutputStream(getFile(file));
            for (var i : array)
                stream.write(i);
            stream.close();
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