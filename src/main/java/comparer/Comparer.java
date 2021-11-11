package comparer;

public abstract class Comparer {
    protected String searchValue;

    public abstract Boolean compare(String s);
    public void setCompareValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
