package args.creator;

import args.SearchArgs;
import org.apache.commons.cli.CommandLine;

public abstract class ArgsCreator {
    public abstract Boolean matches(CommandLine cmd);
    public abstract SearchArgs createSearchArgs(CommandLine cmd);
}
