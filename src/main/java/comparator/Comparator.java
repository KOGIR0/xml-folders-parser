package comparator;

public abstract class Comparator {
    protected String searchValue;

    public abstract Boolean compare(String s);
    public void setCompareValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
