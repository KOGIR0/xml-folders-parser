package fileprocessor;

import constant.Constants;

import java.util.List;

public class PrintFileProcessor extends FileProcessor{
    public void process(List<String> path2file, String filename) {
        StringBuilder path = new StringBuilder(path2file.get(0));
        for(int i = 1; i < path2file.size(); i++) {
            path.append(path2file.get(i)).append(Constants.SPLIT_DIR);
        }
        path.append(filename);
        System.out.println(path);
    }
}
