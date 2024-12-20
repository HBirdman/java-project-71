package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Differ {
    private String key;
    private String status;
    private Object valueBefore;
    private Object valueAfter;

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);
        Map<String, Object> combinedMap = new TreeMap<>(map1);
        combinedMap.putAll(map2);
        List<Differ> differs = transform(combinedMap.entrySet(), map1, map2);
        return Formatter.format(differs, format);
    }

    public static List<Differ> transform(
            Set<Map.Entry<String, Object>> entries,
            Map<String, Object> map1,
            Map<String, Object> map2) {
        List<Differ> differs = new ArrayList<>();
        for (var entry : entries) {
            String key = entry.getKey();
            if (!map1.containsKey(key)) {
                differs.add(new Differ(key, Constant.STATUS_ADDED, '-', map2.get(key)));
            } else if (!map2.containsKey(key)) {
                differs.add(new Differ(key, Constant.STATUS_DELETED, map1.get(key), '-'));
            } else if (Objects.equals(map2.get(key), map1.get(key))) {
                differs.add(new Differ(key, Constant.STATUS_UNCHANGED, map1.get(key), '-'));
            } else if (!Objects.equals(map2.get(key), map1.get(key))) {
                differs.add(new Differ(key, Constant.STATUS_MODIFIED, map1.get(key), map2.get(key)));
            }
        }
        return differs;
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
