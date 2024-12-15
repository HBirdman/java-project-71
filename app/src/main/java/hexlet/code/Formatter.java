package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<Differ> diff, String formatName) throws Exception {
        formatName = formatName.toLowerCase().trim();
        return switch (formatName) {
            case "stylish" -> Stylish.format(diff);
            case "plain" -> Plain.format(diff);
            case "json" -> Json.format(diff);
            default -> throw new Exception("Unknown format: '" + formatName + "'");
        };
    }
}
