package pathprocessor;

import java.util.ArrayList;
import java.util.List;

public abstract class PathProcessor {
    public Boolean isFile = false;
    public List<String> currentPath = new ArrayList<>();

    public abstract void store(String value);

    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }

    public void leaveDir() {
        if(!this.isFile) {
            this.currentPath.remove(this.currentPath.size() - 1);
        } else {
            this.isFile = false;
        }
    }
    public void enterDir(String dir) {
        this.currentPath.add(dir);
    }

}
