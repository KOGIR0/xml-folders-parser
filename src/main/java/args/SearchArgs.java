package args;

import constant.SearchType;

public class SearchArgs {
    private String filePath, searchValue;
    private SearchType searchType;

    public String getFilePath() {
        return filePath;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public SearchArgs(String filePath, String searchValue, SearchType searchType) {
        this.filePath = filePath;
        this.searchValue = searchValue;
        this.searchType = searchType;
    }

    public SearchArgs(String filePath) {
        this.filePath = filePath;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public SearchType getSearchType() {
        return this.searchType;
    }
}
