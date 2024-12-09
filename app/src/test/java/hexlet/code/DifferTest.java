package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private Map<String, Object> json1;
    private Map<String, Object> json2;
    private Map<String, Object> yaml1;
    private Map<String, Object> yaml2;


    @BeforeEach
    public void beforeEach() throws Exception {
        this.json1 = Parser.parseJson(
                String.valueOf(Parser.getPath("src/test/resources/fixtures/file1.json"))
        );
        this.json2 = Parser.parseJson(
                String.valueOf(Parser.getPath("src/test/resources/fixtures/file2.json"))
        );
        this.yaml1 = Parser.parseYaml(
                String.valueOf(Parser.getPath("src/test/resources/fixtures/file1.yml"))
        );
        this.yaml2 = Parser.parseYaml(
                String.valueOf(Parser.getPath("src/test/resources/fixtures/file2.yml"))
        );
    }

    @Test
    public void testGenerateJson() {
        String result = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(result, Differ.generate(json1, json2));
    }

    @Test
    public void testGenerateYaml() {
        String result = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(result, Differ.generate(json1, json2));
    }
}
