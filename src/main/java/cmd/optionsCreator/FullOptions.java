package cmd.optionsCreator;

import cmd.SearchOptions;
import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.CommandLine;

public class FullOptions implements IOptionsCreator {

    @Override
    public Boolean matches(CommandLine cmd) {
        return true;
    }

    @Override
    public SearchOptions getOptions(CommandLine cmd) {
        return new SearchOptions(
                cmd.getOptionValue(Constants.OPTION_FILE),
                null,
                SearchType.Full);
    }
}
