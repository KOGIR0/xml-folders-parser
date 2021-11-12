package args.creator;

import args.SearchArgs;
import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.CommandLine;

public class EqualSearchArgsCreator extends SearchArgsCreator {

    @Override
    public Boolean matches(CommandLine cmd) {
        if(cmd.hasOption(Constants.KEY_MACK)) {
            StringBuilder searchValue = new StringBuilder(cmd.getOptionValue(Constants.OPTION_SEARCH));
            return searchValue.charAt(0) != Constants.APOSTROPHE1;
        }
        return false;
    }

    @Override
    public SearchArgs createSearchArgs(CommandLine cmd) {
        return new SearchArgs(
                cmd.getOptionValue(Constants.OPTION_FILE),
                cmd.getOptionValue(Constants.OPTION_SEARCH),
                SearchType.Equals);
    }
}
