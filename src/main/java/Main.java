import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.xml.sax.SAXException;
import parser.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static final String FILENAME = "src/main/java/resources/test-files.xml";

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
            formatter.printHelp("xml file search", options);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
