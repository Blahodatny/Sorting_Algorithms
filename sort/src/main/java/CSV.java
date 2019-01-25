import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSV {
    public List<String[]> readFile(String file) {
        BufferedReader reader = null;
        String line;
        List<String[]> list = new ArrayList<>();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getClass().getResourceAsStream("/" + file))
            );
            while ((line = reader.readLine()) != null)
                list.add(line.split("\\s*,\\s*"));
        } catch (IOException e) {
            e.printStackTrace();
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