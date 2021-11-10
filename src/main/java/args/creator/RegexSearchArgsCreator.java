package args.creator;

import args.SearchArgs;
import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.CommandLine;

public class RegexSearchArgsCreator extends ArgsCreator {
    @Override
    public Boolean matches(CommandLine cmd) {
        return cmd.hasOption(Constants.KEY_MACK_REGULAR);
    }

    @Override
    public SearchArgs createSearchArgs(CommandLine cmd) {
        return new SearchArgs(
                cmd.getOptionValue(Constants.OPTION_FILE),
                cmd.getOptionValue(Constants.OPTION_REGEX_SEARCH),
                SearchType.Regular);
    }
}
