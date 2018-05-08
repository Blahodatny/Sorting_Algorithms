package file_worker;

import java.io.*;
import java.util.stream.IntStream;

public class FileWorker {
    private void exists(String fileName) throws FileNotFoundException {
        var file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException(file.getName());
    }

    public void write(String fileName, int[] array) {
        var file = new File(fileName);

        try {
            if (!file.exists())
                System.out.println(file.createNewFile());

            try (var out = new PrintWriter(file.getAbsoluteFile())) {
                IntStream.range(0, array.length).forEach(i -> {
                    out.print(array[i]);
                    if (i != array.length - 1)
                        out.print("\n");
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int[] read(String fileName, int number) throws FileNotFoundException {
        exists(fileName);
        var buffer = new int[number];
        try {
            try (var in = new BufferedReader(new FileReader(new File(fileName)))) {
                var i = 0;
                var s = in.readLine();
                while (i < number) {
                    buffer[i] = Integer.parseInt(s);
                    s = in.readLine();
                    i++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return buffer;
    }
}