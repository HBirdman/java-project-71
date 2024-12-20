package hexlet.code;

import lombok.Getter;
import lombok.Setter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(
        version = "1.0.0",
        mixinStandardHelpOptions = true,
        name = "gendiff",
        description = "Compares two configuration files and shows a difference."
)
@Getter
@Setter
final class App implements Callable<String> {

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    private boolean versionInfoRequested;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            defaultValue = "stylish", description = "output format [default: ${DEFAULT-VALUE}]")
    private static String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private static String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private static String filepath2;

    @Override
    public String call() throws Exception {
        String result = Differ.generate(filepath1, filepath2, format);
        System.out.println(result);
        return result;
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
}
