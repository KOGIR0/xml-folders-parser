package comparator;

import constant.Constants;
import fileprocessor.FileProcessor;

public abstract class Comparator extends FileProcessor {
    protected String searchValue;

    public void store(String value) {
        if (this.isFile) {
            if (this.compare(value)) {
                process(value);
            }
        } else {
            this.enterDir(value);
        }
    }

    public void process(String filename) {
        StringBuilder path = new StringBuilder(currentPath.get(0));
        for(int i = 1; i < currentPath.size(); i++) {
            path.append(currentPath.get(i)).append(Constants.SPLIT_DIR);
        }
        path.append(filename);
        System.out.println(path);
    }

    public abstract Boolean compare(String s);
    public void setCompareValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
