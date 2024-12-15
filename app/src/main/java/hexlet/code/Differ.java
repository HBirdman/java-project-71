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
    private Character status;
    private Object valueBefore;
    private Object valueAfter;

    public static String generate(Map<String, Object> map1, Map<String, Object> map2, String format) throws Exception {
        Map<String, Object> combinedMap = new TreeMap<>(map1);
        combinedMap.putAll(map2);
        Set<Map.Entry<String, Object>> entries = combinedMap.entrySet();
        List<Differ> differs = new ArrayList<>();
        for (var entry : entries) {
            String key = entry.getKey();
            if (!map1.containsKey(key)) {
                differs.add(new Differ(key, '+', 000, map2.get(key)));
            } else if (!map2.containsKey(key)) {
                differs.add(new Differ(key, '-', map1.get(key), 000));
            } else if (Objects.equals(map2.get(key), map1.get(key))) {
                differs.add(new Differ(key, ' ', map1.get(key), 000));
            } else if (!Objects.equals(map2.get(key), map1.get(key))) {
                differs.add(new Differ(key, '~', map1.get(key), map2.get(key)));
            }
        }

        return Formatter.format(differs, format);
    }
}
