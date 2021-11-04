import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.xml.sax.SAXException;
import cmd.CmdOptions;
import cmd.SearchOptions;
import saxparser.SaxParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SaxParser sp = new SaxParser();
        CmdOptions options = new CmdOptions();
        try {
            options.tryParseArgs(args);
            SearchOptions so = options.getSearchOptions();
            sp.parse(so);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar assembly.jar -f path/to/file", options);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
