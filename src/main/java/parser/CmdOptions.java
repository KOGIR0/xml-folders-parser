package parser;

import org.apache.commons.cli.*;

public class CmdOptions extends Options {
    private StringBuilder inputFilePath, searchValue;
    private SearchType st;
    private CommandLine cmd;

    public CmdOptions() {
        this.addFileOption();
        this.addSearchOption();
        this.addRegexSearchOption();
    }

    // try parse command line args
    // if wrong print available app options
    public void tryParseArgs(String[] cmdArgs) throws ParseException {
        CommandLineParser cmdParser = new DefaultParser();
        this.cmd = cmdParser.parse(this, cmdArgs);
    }

    public SearchOptions getSearchOptions() {
        inputFilePath = new StringBuilder(cmd.getOptionValue("file"));
        if(cmd.getOptionValue("search") != null) {
            searchValue = new StringBuilder(cmd.getOptionValue("search"));
        }
        SearchType searchType;

        if(cmd.hasOption("-s")) {
            // if contains apostrophe, remove it and search by mask, otherwise search by equality
            if(searchValue.charAt(0) == Constants.APOSTROPHE1) {
                searchValue.deleteCharAt(0);
                searchValue.deleteCharAt(searchValue.length() - 1);
                searchType = SearchType.Mask;
            } else {
                searchType =  SearchType.Equals;
            }
        } else if(cmd.hasOption("-S")) {
            searchType = SearchType.Regular;
        } else {
            searchType = SearchType.Full;
            return new SearchOptions(inputFilePath.toString(), null, searchType);
        }
        return new SearchOptions(inputFilePath.toString(), searchValue.toString(), searchType);
    }

    private void addFileOption() {
        Option xmlFileInput = new Option("f", "file", true, "xml file path");
        xmlFileInput.setRequired(true);
        this.addOption(xmlFileInput);
    }

    private void addSearchOption() {
        Option searchInput = new Option("s", "search", true, "search string");
        searchInput.setRequired(false);
        this.addOption(searchInput);
    }

    private void addRegexSearchOption() {
        Option searchByRegexInput = new Option("S", "Search", true, "search with regex");
        searchByRegexInput.setRequired(false);
        this.addOption(searchByRegexInput);
    }
}
