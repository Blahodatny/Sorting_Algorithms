package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSV {
    public List<String[]> readFile(String file) {
        BufferedReader reader = null;
        List<String[]> list;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            getClass().getResourceAsStream("/" + file)
                    )
            );
            list = reader
                    .lines()
                    .map(line -> line.split("\\s*,\\s*"))
                    .collect(Collectors.toList());
        } finally {
            try {
                Objects.requireNonNull(reader).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}