package cmd;

import cmd.optionsCreator.*;
import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;

public class CmdOptions extends Options {
    private CommandLine cmd;
    List<IOptionsCreator> optionCreators = new ArrayList<>();

    public CmdOptions() {
        this.addFileOption();
        this.addSearchOption();
        this.addRegexSearchOption();

        this.optionCreators.add(new EqualsOptions());
        this.optionCreators.add(new MaskOptions());
        this.optionCreators.add(new RegexOptions());
    }

    public void tryParseArgs(String[] cmdArgs) throws ParseException {
        CommandLineParser cmdParser = new DefaultParser();
        this.cmd = cmdParser.parse(this, cmdArgs);
    }

    public SearchOptions getSearchOptions() {
        for(IOptionsCreator creator: optionCreators) {
            if(creator.matches(this.cmd)) {
                return creator.getOptions(this.cmd);
            }
        }
        return new FullOptions().getOptions(cmd);
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
