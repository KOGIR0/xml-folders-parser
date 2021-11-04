package search;

public class ExactSearch extends FileSearchHandler {

    @Override
    protected Boolean Compare(String s) {
        return this.searchValue.equals(s);
    }
}
