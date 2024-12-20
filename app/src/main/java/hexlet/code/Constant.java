package hexlet.code;

import lombok.Getter;

@Getter
public class Constant {
    public static final String FORMAT_JSON = "json";
    public static final String FORMAT_YAML = "yml";
    public static final String STATUS_ADDED = "added";
    public static final String STATUS_DELETED = "deleted";
    public static final String STATUS_UNCHANGED = "unchanged";
    public static final String STATUS_MODIFIED = "modified";
    public static final String jsonFile1 = "src/test/resources/fixtures/file1.json";
    public static final String jsonFile2 = "src/test/resources/fixtures/file2.json";
    public static final String yamlFile1 = "src/test/resources/fixtures/file1.yml";
    public static final String yamlFile2 = "src/test/resources/fixtures/file2.yml";
    public static final String stylishResult = "src/test/resources/fixtures/stylishResult.txt";
    public static final String plainResult = "src/test/resources/fixtures/plainResult.txt";
    public static final String jsonResult = "src/test/resources/fixtures/jsonResult.txt";
}
