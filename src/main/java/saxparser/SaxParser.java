package saxparser;

import org.xml.sax.SAXException;
import cmd.SearchOptions;
import search.FileSearchHandler;
import search.XmlSearchFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {
    private SAXParserFactory factory = SAXParserFactory.newInstance();

    public void parse(SearchOptions so) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = factory.newSAXParser();
        FileSearchHandler handler = XmlSearchFactory.getSearchHandler(so.getSearchType());
        handler.setSearchValue(so.getSearchValue());
        parser.parse(so.getFilePath(), handler);
    }
}
