package saxparser;

import comparer.Comparer;
import comparer.ComparerFactory;
import fileprocessor.FileProcessor;
import fileprocessor.PrintFileProcessor;
import org.xml.sax.SAXException;
import args.SearchArgs;

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

        NodeParser nodeParser = new NodeParser();

        Comparer comparer = ComparerFactory.getComparer(so.getSearchType());
        comparer.setCompareValue(so.getSearchValue());
        nodeParser.setComparer(comparer);

        FileProcessor fileProcessor = new PrintFileProcessor();
        nodeParser.setFileProcessor(fileProcessor);

        parser.parse(so.getFilePath(), nodeParser);
    }
}