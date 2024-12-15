package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class Plain {
    public static String format(List<Differ> differs) {
        StringBuilder result = new StringBuilder();
        for (Differ differ : differs) {
            Object before = differ.getValueBefore();
            Object after = differ.getValueAfter();
            if (before instanceof ArrayList || before instanceof LinkedHashMap) {
                before = "[complex value]";
            } else if (before instanceof String) {
                before = "'" + before + "'";
            }
            if (after instanceof ArrayList || after instanceof LinkedHashMap) {
                after = "[complex value]";
            } else if (after instanceof String) {
                after = "'" + after + "'";
            }
            if (Objects.equals(differ.getStatus(), "modified")) {
                result.append("Property '").append(differ.getKey())
                        .append("' was updated. From ").append(before)
                        .append(" to ").append(after).append("\n");
            } else if (Objects.equals(differ.getStatus(), "added")) {
                result.append("Property '").append(differ.getKey())
                        .append("' was added with value: ")
                        .append(after).append("\n");
            } else if (Objects.equals(differ.getStatus(), "deleted")) {
                result.append("Property '").append(differ.getKey())
                        .append("' was removed")
                        .append("\n");
            }
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
