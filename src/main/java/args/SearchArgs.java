package args;

import constant.SearchType;

public class SearchArgs {
    private String filePath, searchValue;
    private SearchType st;

    public String getFilePath() {
        return filePath;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public SearchArgs(String filePath, String searchValue, SearchType st) {
        this.filePath = filePath;
        this.searchValue = searchValue;
        this.st = st;
    }

    public SearchType getSearchType() {
        return this.st;
    }
}
