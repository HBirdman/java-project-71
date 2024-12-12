package hexlet.code;

import java.util.List;
import java.util.Objects;


public class Stylish {
    public static String format(List<Differ> differs) {
        StringBuilder result = new StringBuilder("{\n");
        for (var differ : differs) {
            if (Objects.equals(differ.getStatus(), ' ')) {
                result.append("    ").append(differ.getKey())
                        .append(": ").append(String.valueOf(differ.getValueBefore()))
                        .append("\n");
            } else if (Objects.equals(differ.getStatus(), '-')) {
                result.append("  - ").append(differ.getKey())
                        .append(": ").append(String.valueOf(differ.getValueBefore()))
                        .append("\n");
                if (!Objects.equals(differ.getValueAfter(), 000)) {
                    result.append("  + ").append(differ.getKey())
                            .append(": ").append(String.valueOf(differ.getValueAfter()))
                            .append("\n");
                }
            } else if (Objects.equals(differ.getStatus(), '+')) {
                result.append("  + ").append(differ.getKey())
                        .append(": ").append(String.valueOf(differ.getValueAfter()))
                        .append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
