package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class DifferTest {
    private final String JSON_FILE1 = "src/test/resources/fixtures/file1.json";
    private final String JSON_FILE2 = "src/test/resources/fixtures/file2.json";
    private final String YAML_FILE1 = "src/test/resources/fixtures/file1.yml";
    private final String YAML_FILE2 = "src/test/resources/fixtures/file2.yml";
    private final String STYLISH_RESULT = "src/test/resources/fixtures/stylishResult.txt";
    private final String PLAIN_RESULT = "src/test/resources/fixtures/plainResult.txt";
    private final String JSON_RESULT = "src/test/resources/fixtures/jsonResult.txt";

    @ParameterizedTest
    @CsvSource({
            JSON_FILE1 + ", " + JSON_FILE2 + ", Stylish, " + STYLISH_RESULT,
            YAML_FILE1 + ", " + YAML_FILE2 + ", Stylish, " + STYLISH_RESULT
    })

    public void testGenerateStylish(
            String filepath1, String filepath2, String format, String resultPath) throws Exception {
        String result = Files.readString(Parser.getPath(resultPath));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @CsvSource({
            JSON_FILE1 + ", " + JSON_FILE2 + ", Plain, " + PLAIN_RESULT,
            YAML_FILE1 + ", " + YAML_FILE2 + ", Plain, " + PLAIN_RESULT
    })

    public void testGeneratePlain(
            String filepath1, String filepath2, String format, String resultPath) throws Exception {
        String result = Files.readString(Parser.getPath(resultPath));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @CsvSource({
            JSON_FILE1 + ", " + JSON_FILE2 + ", Json, " + JSON_RESULT,
            YAML_FILE1 + ", " + YAML_FILE2 + ", Json, " + JSON_RESULT
    })

    public void testGenerateJson(
            String filepath1, String filepath2, String format, String resultPath) throws Exception {
        String result = Files.readString(Parser.getPath(resultPath));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(result, actual);
    }
}
