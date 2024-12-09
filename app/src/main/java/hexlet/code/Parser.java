package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseYaml(String path) throws Exception {
        InputStream inputStream = new FileInputStream(new File(String.valueOf(getPath(path))));
        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }

    public static Map<String, Object> parseJson(String path) throws Exception {
        String fileText = Files.readString(getPath(path));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileText, new TypeReference<>() { });
    }

    public static Path getPath(String path) throws Exception {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        return filePath;
    }
}
