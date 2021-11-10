package cmd.optionsCreator;

import cmd.SearchOptions;
import org.apache.commons.cli.CommandLine;

public interface IOptionsCreator {
    Boolean matches(CommandLine cmd);
    SearchOptions getOptions(CommandLine cmd);
}
