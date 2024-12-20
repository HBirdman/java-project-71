package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.nio.file.Files;

import static hexlet.code.Constant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class DifferTest {

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
