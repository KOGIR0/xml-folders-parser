package args;

import constant.Constants;
import constant.SearchType;
import org.apache.commons.cli.*;

public class ArgsParser extends Options {
    private CommandLine args;

    public ArgsParser() {
        this.addOption("f", "file", true, "xml file path", true);
        this.addOption("s", "search", true, "search string", false);
        this.addOption("S", "Search", true, "search with regex", false);
    }

    public void tryParseArgs(String[] cmdArgs) throws ParseException {
        CommandLineParser cmdParser = new DefaultParser();
        this.args = cmdParser.parse(this, cmdArgs);
    }

    public SearchArgs getSearchArgs() {
        String filePath = args.getOptionValue(Constants.OPTION_FILE);
        SearchArgs searchArgs = new SearchArgs(filePath);

        if(this.args.hasOption(Constants.KEY_MACK_REGULAR)) {
            // search by regex
            searchArgs.setSearchValue(this.args.getOptionValue(Constants.OPTION_REGEX_SEARCH));
            searchArgs.setSearchType(SearchType.Regular);
        } else if(args.hasOption(Constants.KEY_MACK)) {
            String searchValue = args.getOptionValue(Constants.OPTION_SEARCH);

            if(searchValue.charAt(0) == Constants.APOSTROPHE1) {
                // search by mask
                searchValue = searchValue.substring(1, searchValue.length() - 1);
                searchValue = searchValue.replace("*", ".*");
                searchValue = searchValue.replace("?", ".");

                searchArgs.setSearchValue(searchValue);
                searchArgs.setSearchType(SearchType.Mask);
            } else {
                // search by equality
                searchArgs.setSearchValue(searchValue);
                searchArgs.setSearchType(SearchType.Equals);
            }
        } else {
            // full search
            searchArgs.setSearchType(SearchType.Full);
        }
        return searchArgs;
    }

    private void addOption(String opt, String longOpt, Boolean hasArgs, String description, Boolean isRequired) {
        Option xmlFileInput = new Option(opt, longOpt, hasArgs, description);
        xmlFileInput.setRequired(isRequired);
        this.addOption(xmlFileInput);
    }
}