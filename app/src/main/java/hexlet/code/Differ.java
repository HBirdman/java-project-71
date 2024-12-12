package hexlet.code;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Differ {
    private String Key;
    private Character Status;
    private Object ValueBefore;
    private Object ValueAfter;

    public static String generate(Map<String, Object> map1, Map<String, Object> map2) {
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
                differs.add(new Differ(key, '-', map1.get(key), 000));
                differs.add(new Differ(key, '+', 000, map2.get(key)));
            }
        }
        return stylish.format(differs);
        }
    }
