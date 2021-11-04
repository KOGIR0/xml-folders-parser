package search;

public class RegexSearch extends FileSearchHandler{

    @Override
    protected Boolean Compare(String s) {
        return s.matches(this.searchValue);
    }
}
