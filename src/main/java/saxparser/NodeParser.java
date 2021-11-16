package saxparser;

import comparator.Comparator;
import fileprocessor.FileProcessor;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import constant.Constants;

public class NodeParser extends DefaultHandler {

    private Boolean isActive = false;
    private Comparator comparator;

    public void setComparator(Comparator comparator) { this.comparator = comparator; }

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
            Boolean isFile = Boolean.valueOf(attribute.getValue(Constants.IS_FILE));
            this.comparator.setIsFile(isFile);
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
            this.comparator.leaveDir();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if(this.isActive) {
            String currentValue = new String(ch).substring(start, start + length);
            this.comparator.store(currentValue);
        }
    }
}