package hexlet.code.formatters;

import hexlet.code.Constant;
import hexlet.code.Differ;

import java.util.List;
import java.util.Objects;


public class Stylish {
    public static String format(List<Differ> differs) {
        StringBuilder result = new StringBuilder("{\n");
        for (Differ differ : differs) {
            Object before = differ.getValueBefore();
            Object after = differ.getValueAfter();
            if (Objects.equals(differ.getStatus(), Constant.STATUS_UNCHANGED)) {
                result.append("    ").append(differ.getKey())
                        .append(": ").append(before)
                        .append("\n");
            } else if (Objects.equals(differ.getStatus(), Constant.STATUS_DELETED)) {
                result.append("  - ").append(differ.getKey())
                        .append(": ").append(before)
                        .append("\n");
            } else if (Objects.equals(differ.getStatus(), Constant.STATUS_ADDED)) {
                result.append("  + ").append(differ.getKey())
                        .append(": ").append(after)
                        .append("\n");
            } else if (Objects.equals(differ.getStatus(), Constant.STATUS_MODIFIED)) {
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
