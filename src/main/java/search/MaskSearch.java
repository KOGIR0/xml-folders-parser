package search;

public class MaskSearch extends FileSearchHandler{

    @Override
    protected Boolean Compare(String s) {
        return s.contains(this.searchValue);
    }
}
