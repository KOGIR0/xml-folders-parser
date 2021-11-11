import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.xml.sax.SAXException;
import args.ArgsParser;
import args.SearchArgs;
import saxparser.SaxParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SaxParser sp = new SaxParser();
        ArgsParser argsParser = new ArgsParser();
        try {
            argsParser.tryParseArgs(args);
            SearchArgs searchArgs = argsParser.getSearchArgs();
            sp.parse(searchArgs);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar assembly.jar -f path/to/file", argsParser);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
