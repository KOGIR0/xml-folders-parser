package args;

import args.creator.*;
import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;

public class ArgsParser extends Options {
    private CommandLine args;
    List<SearchArgsCreator> searchArgsCreators = new ArrayList<>();

    public ArgsParser() {
        this.addFileOption();
        this.addSearchOption();
        this.addRegexSearchOption();

        this.searchArgsCreators.add(new EqualSearchArgsCreator());
        this.searchArgsCreators.add(new MaskSearchArgsCreator());
        this.searchArgsCreators.add(new RegexSearchArgsCreator());
    }

    public void tryParseArgs(String[] cmdArgs) throws ParseException {
        CommandLineParser cmdParser = new DefaultParser();
        this.args = cmdParser.parse(this, cmdArgs);
    }

    public SearchArgs getSearchArgs() {
        for(SearchArgsCreator creator: searchArgsCreators) {
            if(creator.matches(this.args)) {
                return creator.createSearchArgs(this.args);
            }
        }
        return new FullSearchArgsCreator().createSearchArgs(args);
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