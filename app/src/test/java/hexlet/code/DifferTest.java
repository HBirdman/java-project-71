package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private String json1;
    private String json2;
    private String yaml1;
    private String yaml2;
    private String resultStylish;
    private String resultPlain;
    private String resultJson;


    @BeforeEach
    public void beforeEach() {
        this.json1 = "src/test/resources/fixtures/file1.json";
        this.json2 = "src/test/resources/fixtures/file2.json";
        this.yaml1 = "src/test/resources/fixtures/file1.yml";
        this.yaml2 = "src/test/resources/fixtures/file2.yml";
        this.resultStylish = """
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
        this.resultJson = """
                {"key":"chars1","status":"unchanged","valueBefore":["a","b","c"],"valueAfter":"-"}
                {"key":"chars2","status":"modified","valueBefore":["d","e","f"],"valueAfter":false}
                {"key":"checked","status":"modified","valueBefore":false,"valueAfter":true}
                {"key":"default","status":"modified","valueBefore":null,"valueAfter":["value1","value2"]}
                {"key":"id","status":"modified","valueBefore":45,"valueAfter":null}
                {"key":"key1","status":"deleted","valueBefore":"value1","valueAfter":"-"}
                {"key":"key2","status":"added","valueBefore":"-","valueAfter":"value2"}
                {"key":"numbers1","status":"unchanged","valueBefore":[1,2,3,4],"valueAfter":"-"}
                {"key":"numbers2","status":"modified","valueBefore":[2,3,4,5],"valueAfter":[22,33,44,55]}
                {"key":"numbers3","status":"deleted","valueBefore":[3,4,5],"valueAfter":"-"}
                {"key":"numbers4","status":"added","valueBefore":"-","valueAfter":[4,5,6]}
                {"key":"obj1","status":"added","valueBefore":"-","valueAfter":{"nestedKey":"value","isNested":true}}
                {"key":"setting1","status":"modified","valueBefore":"Some value","valueAfter":"Another value"}
                {"key":"setting2","status":"modified","valueBefore":200,"valueAfter":300}
                {"key":"setting3","status":"modified","valueBefore":true,"valueAfter":"none"}""";
    }

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
        assertEquals(resultPlain, Differ.generate(json1, json2, "plain"));
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
