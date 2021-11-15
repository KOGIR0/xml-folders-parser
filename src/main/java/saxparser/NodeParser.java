package saxparser;

import comparer.Comparator;
import fileprocessor.FileProcessor;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class NodeParser extends DefaultHandler {

    private List<String> currentPath = new ArrayList<>();
    private Boolean currentIsFile = false;
    private Boolean isActive = false;

    private Comparator comparator;
    private FileProcessor fileProcessor;

    public void setComparator(Comparator comparator) { this.comparator = comparator; }
    public void setFileProcessor(FileProcessor fileProcessor) { this.fileProcessor = fileProcessor; }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attribute) {

        if(qName.equalsIgnoreCase(Constants.ACTIVE_NODE)) {
            this.isActive = true;
        }

        if(qName.equalsIgnoreCase(Constants.INCLUDE_NODE)) {
            this.currentIsFile = Boolean.valueOf(attribute.getValue(Constants.IS_FILE));
        }
    }

    @Override
    public void endElement(
            String uri,
            String localName,
            String qName) {

        if(qName.equalsIgnoreCase(Constants.ACTIVE_NODE)) {
            this.isActive = false;
        }

        if(qName.equalsIgnoreCase(Constants.INCLUDE_NODE)) {
            if(!this.currentIsFile) {
                this.currentPath.remove(this.currentPath.size() - 1);
            } else {
                this.currentIsFile = false;
            }
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if(this.isActive) {
            String currentValue = new String(ch).substring(start, start + length);
            this.processActiveNodeValue(currentValue);
        }
    }

    private void processActiveNodeValue(String value)
    {
        if (this.currentIsFile) {
            if (this.comparator.compare(value)) {
                this.fileProcessor.process(this.currentPath, value);
            }
        } else if (!value.equals(Constants.SPLIT_DIR)) {
            this.currentPath.add(value);
        }
    }
}