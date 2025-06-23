package CoreJava.ClassLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class YmlReader {
    private final Map<String, String> data = new HashMap<>();
    public YmlReader(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line=reader.readLine())!=null){
                line=line.trim();
                if (!line.isEmpty() && line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    data.put(key, value);
                }
            }
        }
    }

    public void printContents() {
        data.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public String getValue(String key) {
        return data.get(key);
    }
}
