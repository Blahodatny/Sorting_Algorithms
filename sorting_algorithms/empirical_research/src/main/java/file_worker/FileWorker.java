package file_worker;

import java.io.*;
import java.util.stream.IntStream;

public class FileWorker {
    private void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException(file.getName());
    }

    public void write(String fileName, int[] array) {
        File file = new File(fileName);

        try {
            if (!file.exists())
                System.out.println(file.createNewFile());

            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
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
        int[] buffer = new int[number];
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName)))) {
                int i = 0;
                String s = in.readLine();
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