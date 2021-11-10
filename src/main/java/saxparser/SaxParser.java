package saxparser;

import org.xml.sax.SAXException;
import args.SearchArgs;
import search.FileSearchHandler;
import search.XmlSearchFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {
    public void parse(SearchArgs so) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser = factory.newSAXParser();

        FileSearchHandler handler = XmlSearchFactory.getSearchHandler(so.getSearchType());
        handler.setSearchValue(so.getSearchValue());

        parser.parse(so.getFilePath(), handler);
    }
}
