package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class FileWorker {
    private File getFile(String file) throws FileNotFoundException {
        return new File(requireNonNull(
                getClass().getClassLoader().getResource("data/" + file)
        ).getFile());
    }

    private void close(FileOutputStream stream) {
        try {
            requireNonNull(stream).close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String file, int[] array) {
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(getFile(file));
            for (var i1 : array) stream.write(i1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            close(stream);
        }
    }
}