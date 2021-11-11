package args.creator;

import args.SearchArgs;
import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.CommandLine;

public class FullSearchArgsCreator extends ArgsCreator {

    @Override
    public Boolean matches(CommandLine cmd) {
        return true;
    }

    @Override
    public SearchArgs createSearchArgs(CommandLine cmd) {
        return new SearchArgs(
                cmd.getOptionValue(Constants.OPTION_FILE),
                null,
                SearchType.Full);
    }
}
