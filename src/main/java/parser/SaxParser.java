package parser;

import org.apache.commons.cli.HelpFormatter;
import org.xml.sax.SAXException;
import org.apache.commons.cli.ParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {
    private SAXParserFactory factory = SAXParserFactory.newInstance();

    public void parse(SearchOptions so) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = factory.newSAXParser();
        NodeParser handler = XmlSearchFactory.getSearchHandler(so);
        parser.parse(so.getFilePath(), handler);
    }
}
