package saxparser;

import comparer.Comparator;
import comparer.CompatorFactory;
import fileprocessor.FileProcessor;
import fileprocessor.PrintFileProcessor;
import org.xml.sax.SAXException;
import args.SearchArgs;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {
    public void parse(SearchArgs searchArgs) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser = factory.newSAXParser();

        NodeParser nodeParser = new NodeParser();

        Comparator comparator = CompatorFactory.getComparer(searchArgs.getSearchType());
        comparator.setCompareValue(searchArgs.getSearchValue());
        nodeParser.setComparator(comparator);

        FileProcessor fileProcessor = new PrintFileProcessor();
        nodeParser.setFileProcessor(fileProcessor);

        parser.parse(searchArgs.getFilePath(), nodeParser);
    }
}