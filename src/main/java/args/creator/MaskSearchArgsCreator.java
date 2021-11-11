package args.creator;

import args.SearchArgs;
import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.CommandLine;

public class MaskSearchArgsCreator extends ArgsCreator {
    public Boolean matches(CommandLine cmd) {
        StringBuilder searchValue;
        if(cmd.hasOption(Constants.KEY_MACK)) {
            searchValue = new StringBuilder(cmd.getOptionValue(Constants.OPTION_SEARCH));
            return searchValue.charAt(0) == Constants.APOSTROPHE1;
        }
        return false;
    }

    public SearchArgs createSearchArgs(CommandLine cmd) {
        String searchValue = cmd.getOptionValue(Constants.OPTION_SEARCH);

        searchValue = searchValue.substring(1, searchValue.length() - 1);
        searchValue = searchValue.replace("*", ".*");
        searchValue = searchValue.replace("?", ".");

        return new SearchArgs(
                cmd.getOptionValue(Constants.OPTION_FILE),
                searchValue.toString(),
                SearchType.Mask);
    }
}
