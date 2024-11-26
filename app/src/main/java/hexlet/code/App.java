package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        mixinStandardHelpOptions = true,
        name = "gendiff",
        description = "Compares two configuration files and shows a difference."
)
public class App implements Runnable {

    @Option(names = { "-V", "--version" }, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish", description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filepath2;

    @Override
    public void run() {
        System.out.println("Hello World!");
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
        new CommandLine(new App()).execute(args);
    }

}
