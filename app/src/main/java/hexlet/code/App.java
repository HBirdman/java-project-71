package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Command(
        mixinStandardHelpOptions = true,
        name = "gendiff",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Runnable {

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    boolean helpRequested = false;

    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish", description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    static String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    static String filepath2;

    @Override
    public void run() {
        Map<String, Object> result;
        try {
            result = readAndParse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        System.out.println(result.get("host"));
        System.out.println(result.get("timeout"));
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            return;
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            return;
        }
        commandLine.execute(args);
    }

    public static Map<String, Object> readAndParse() throws Exception {
        String fileText1 = Files.readString(getPath(filepath1));
        String fileText2 = Files.readString(getPath(filepath2));
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data1 = mapper.readValue(fileText1, new TypeReference<>(){});
        return data1;
    }

    public static Path getPath(String path) throws Exception {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        return filePath;
    }
}
