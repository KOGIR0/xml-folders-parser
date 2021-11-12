package fileprocessor;

import constant.Constants;

import java.util.List;

public class PrintFileProcessor extends FileProcessor{
    public void process(List<String> path2file, String filename) {
        StringBuilder path = new StringBuilder();
        path2file.forEach((item) -> path.append(Constants.SPLIT_DIR).append(item));
        path.append(Constants.SPLIT_DIR).append(filename);
        System.out.println(path);
    }
}
