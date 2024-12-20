package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class DifferTest {
    private final String jsonFile1 = "src/test/resources/fixtures/file1.json";
    private final String jsonFile2 = "src/test/resources/fixtures/file2.json";
    private final String yamlFile1 = "src/test/resources/fixtures/file1.yml";
    private final String yamlFile2 = "src/test/resources/fixtures/file2.yml";
    private final String stylishResult = "src/test/resources/fixtures/stylishResult.txt";
    private final String plainResult = "src/test/resources/fixtures/plainResult.txt";
    private final String jsonResult = "src/test/resources/fixtures/jsonResult.txt";

    @ParameterizedTest
    @CsvSource({
        jsonFile1 + ", " + jsonFile2 + ", Stylish, " + stylishResult,
        yamlFile1 + ", " + yamlFile2 + ", Stylish, " + stylishResult
    })

    public void testGenerateStylish(
            String filepath1, String filepath2, String format, String resultPath) throws Exception {
        String result = Files.readString(Parser.getPath(resultPath));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @CsvSource({
        jsonFile1 + ", " + jsonFile2 + ", Plain, " + plainResult,
        yamlFile1 + ", " + yamlFile2 + ", Plain, " + plainResult
    })

    public void testGeneratePlain(
            String filepath1, String filepath2, String format, String resultPath) throws Exception {
        String result = Files.readString(Parser.getPath(resultPath));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(result, actual);
    }

    @ParameterizedTest
    @CsvSource({
        jsonFile1 + ", " + jsonFile2 + ", Json, " + jsonResult,
        yamlFile1 + ", " + yamlFile2 + ", Json, " + jsonResult
    })

    public void testGenerateJson(
            String filepath1, String filepath2, String format, String resultPath) throws Exception {
        String result = Files.readString(Parser.getPath(resultPath));
        String actual = Differ.generate(filepath1, filepath2, format);
        assertEquals(result, actual);
    }
}
