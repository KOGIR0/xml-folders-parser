package cmd.optionsCreator;

import cmd.SearchOptions;
import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.CommandLine;

public class RegexOptions implements IOptionsCreator {
    @Override
    public Boolean matches(CommandLine cmd) {
        return cmd.hasOption(Constants.KEY_MACK_REGULAR);
    }

    @Override
    public SearchOptions getOptions(CommandLine cmd) {
        return new SearchOptions(
                cmd.getOptionValue(Constants.OPTION_FILE),
                cmd.getOptionValue(Constants.OPTION_REGEX_SEARCH),
                SearchType.Regular);
    }
}
