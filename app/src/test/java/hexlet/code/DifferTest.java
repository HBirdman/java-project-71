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
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertEquals(result, Differ.generate(json1, json2));
    }

    @Test
    public void testGenerateYaml() {
        String result = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertEquals(result, Differ.generate(yaml1, yaml2));
    }
}
