package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class DifferTest {
    private String json1;
    private String json2;
    private String yaml1;
    private String yaml2;
    private String resultStylish;
    private String resultPlain;
    private String resultJson;


    @BeforeEach
    public void beforeAll() throws Exception {
        this.json1 = "src/test/resources/fixtures/file1.json";
        this.json2 = "src/test/resources/fixtures/file2.json";
        this.yaml1 = "src/test/resources/fixtures/file1.yml";
        this.yaml2 = "src/test/resources/fixtures/file2.yml";
        this.resultStylish = Files.readString(Parser.getPath("src/test/resources/fixtures/stylishResult.txt"));
        this.resultPlain = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        this.resultJson = new String
                (Files.readAllBytes(Parser.getPath("src/test/resources/fixtures/jsonResult.txt")));
    }

    //@ParameterizedTest
    //@CsvSource({
    //        json1, json2,"plain",
    //})
    //public void testGenerateJsonStylish(
    //        String filepath1, String filepath2, String format, String result) throws Exception {
    //    String actual = Differ.generate(filepath1, filepath2, format);
    //    assertEquals(result, actual);
    //}

    @Test
    public void testGenerateJsonStylish() throws Exception {
        assertEquals(resultStylish, Differ.generate(json1, json2));
    }

    @Test
    public void testGenerateYamlStylish() throws Exception {
        assertEquals(resultStylish, Differ.generate(yaml1, yaml2));
    }

    @Test
    public void testGenerateJsonPlain() throws Exception {
        String actual = Differ.generate(json1, json2, "plain");
        assertEquals(resultPlain, actual);
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        assertEquals(resultPlain, Differ.generate(yaml1, yaml2, "plain"));
    }

    @Test
    public void testGenerateJsonJson() throws Exception {
        assertEquals(resultJson, Differ.generate(json1, json2, "json"));
    }

    @Test
    public void testGenerateYamlJson() throws Exception {
        assertEquals(resultJson, Differ.generate(yaml1, yaml2, "json"));
    }
}