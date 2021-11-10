package cmd.optionsCreator;

import cmd.SearchOptions;
import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.CommandLine;

public class MaskOptions implements IOptionsCreator {
    public Boolean matches(CommandLine cmd) {
        StringBuilder searchValue;
        if(cmd.hasOption(Constants.KEY_MACK)) {
            searchValue = new StringBuilder(cmd.getOptionValue(Constants.OPTION_SEARCH));
            return searchValue.charAt(0) == Constants.APOSTROPHE1;
        }
        return false;
    }

    public SearchOptions getOptions(CommandLine cmd) {
        StringBuilder searchValue = new StringBuilder(cmd.getOptionValue(Constants.OPTION_SEARCH));
        searchValue.deleteCharAt(0);
        searchValue.deleteCharAt(searchValue.length() - 1);

        return new SearchOptions(
                cmd.getOptionValue(Constants.OPTION_FILE),
                searchValue.toString(),
                SearchType.Mask);
    }
}
