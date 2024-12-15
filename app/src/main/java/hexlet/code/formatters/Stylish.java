package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.List;
import java.util.Objects;


public class Stylish {
    public static String format(List<Differ> differs) {
        StringBuilder result = new StringBuilder("{\n");
        for (Differ differ : differs) {
            Object before = differ.getValueBefore();
            Object after = differ.getValueAfter();
            if (Objects.equals(differ.getStatus(), "unchanged")) {
                result.append("    ").append(differ.getKey())
                        .append(": ").append(before)
                        .append("\n");
            } else if (Objects.equals(differ.getStatus(), "deleted")) {
                result.append("  - ").append(differ.getKey())
                        .append(": ").append(before)
                        .append("\n");
            } else if (Objects.equals(differ.getStatus(), "added")) {
                result.append("  + ").append(differ.getKey())
                        .append(": ").append(after)
                        .append("\n");
            } else if (Objects.equals(differ.getStatus(), "modified")) {
                result.append("  - ").append(differ.getKey())
                        .append(": ").append(before)
                        .append("\n");
                result.append("  + ").append(differ.getKey())
                        .append(": ").append(after)
                        .append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
