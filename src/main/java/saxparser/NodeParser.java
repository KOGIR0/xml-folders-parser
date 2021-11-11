package saxparser;

import comparer.Comparer;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class NodeParser extends DefaultHandler {

    private StringBuilder currentValue = new StringBuilder();
    private List<String> currentPath = new ArrayList<>();
    private Boolean currentIsFile = false;

    private Comparer comparer;

    public void setComparer(Comparer comparer) { this.comparer = comparer; }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attribute) {

        currentValue.setLength(0);

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
            if(this.currentIsFile) {
                if(this.comparer.compare(this.currentValue.toString())) {
                    StringBuilder path = new StringBuilder();
                    this.currentPath.forEach((item) -> path.append(Constants.SPLIT_DIR).append(item));
                    path.append(Constants.SPLIT_DIR).append(this.currentValue);
                    System.out.println(path);
                }
            } else {
                if(!this.currentValue.toString().equals(Constants.SPLIT_DIR)) {
                    this.currentPath.add(this.currentValue.toString());
                }
            }
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
        currentValue.append(ch, start, length);
    }
}
