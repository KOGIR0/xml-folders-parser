package fileprocessor;

import java.util.List;

public abstract class FileProcessor {
    public abstract void process(List<String> path2file, String filename);
}
