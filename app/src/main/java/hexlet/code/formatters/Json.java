package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;

import java.util.List;

public class Json {
    public static String format(List<Differ> differs) throws JsonProcessingException {
        StringBuilder result = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Differ differ : differs) {
            result.append(objectMapper.writeValueAsString(differ)).append("\n");
        }
        return result.toString();
    }
}
