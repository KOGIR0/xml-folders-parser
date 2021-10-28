package parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public abstract class NodeParser extends DefaultHandler {
    private StringBuilder currentValue = new StringBuilder();
    private StringBuilder currentPath = new StringBuilder();
    private Boolean currentIsFile = false;

    protected abstract Boolean Compare(String s);

    @Override
    public void startDocument() {
        System.out.println("Document start");
    }

    @Override
    public void endDocument() {
        System.out.println("Document end");
    }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attribute) {

        currentValue.setLength(0);

        if(qName.equalsIgnoreCase("node")) {
            this.currentIsFile = Boolean.valueOf(attribute.getValue(Constants.IS_FILE));
        }

        if(qName.equalsIgnoreCase("child")) {
            this.currentIsFile = Boolean.valueOf(attribute.getValue(Constants.IS_FILE));
        }
    }

    @Override
    public void endElement(
            String uri,
            String localName,
            String qName) {

        if(qName.equalsIgnoreCase("name")) {
            if(this.currentIsFile) {
                if(this.Compare(this.currentValue.toString())) {
                    System.out.println(this.currentPath + Constants.SPLIT_DIR + this.currentValue);
                }
            } else {
                if(!this.currentValue.toString().equals("/")) {
                    this.currentPath.append("/")
                            .append(this.currentValue);
                }
            }
        }

        if(qName.equalsIgnoreCase("child")) {
            if(!this.currentIsFile) {
                int start = this.currentPath.lastIndexOf("/");
                this.currentPath.delete(start, this.currentPath.length());
            } else {
                this.currentIsFile = false;
            }
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        currentValue.append(ch, start, length);
    }
}
