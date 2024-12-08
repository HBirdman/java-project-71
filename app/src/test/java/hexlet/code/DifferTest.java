package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private Map<String, Object> file1;
    private Map<String, Object> file2;
    //private Map<String, Object> file3;

    @BeforeEach
    public void beforeEach() throws Exception {
        this.file1 = App.readAndParse(
                String.valueOf(App.getPath("src/test/resources/fixtures/file1.json"))
        );
        this.file2 = App.readAndParse(
                String.valueOf(App.getPath("src/test/resources/fixtures/file2.json"))
        );
        //this.file3 = App.readAndParse(
        //        String.valueOf(App.getPath("src/test/resources/fixtures/file3.json"))
        //);
    }

    @Test
    public void testGenerate() {
        String result = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(result, Differ.generate(file1, file2));
    }

    @Test
    public void testGenerate2() {
        String result = """
                {
                  + follow: false
                    host: hexlet.io
                  + proxy: 123.234.53.22
                  - timeout: 20
                  + timeout: 50
                  - verbose: true
                }""";
        assertEquals(result, Differ.generate(file2, file1));
    }
}
