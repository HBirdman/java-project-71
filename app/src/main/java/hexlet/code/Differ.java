package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Differ {
    public static String generate(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> combinedMap = new TreeMap<>(map1);
        combinedMap.putAll(map2);
        Set<Map.Entry<String, Object>> entries = combinedMap.entrySet();
        StringBuilder result = new StringBuilder("{\n");
        for (var entry : entries) {
            String key = entry.getKey();
            if (!map1.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (!map2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (map1.get(key).equals(map2.get(key))) {
                result.append("    ").append(key).append(": ").append(entry.getValue()).append("\n");
            } else if (!map1.get(key).equals(map2.get(key))) {
                result.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
                result.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
