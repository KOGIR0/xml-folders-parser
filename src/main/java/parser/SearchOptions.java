package parser;

public class SearchOptions {
    private String filePath, searchValue;
    private SearchType st;

    public SearchOptions(String filePath) {
        this.filePath = filePath;
        this.st = SearchType.Full;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public SearchOptions(String filePath, String searchValue, SearchType st) {
        this.filePath = filePath;
        this.searchValue = searchValue;
        this.st = st;
    }

    public SearchType getSearchType() {
        return this.st;
    }
}
