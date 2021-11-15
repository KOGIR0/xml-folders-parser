package comparer;

public class ExactComparer extends Comparator {
    @Override
    public Boolean compare(String s) {
        return this.searchValue.equals(s);
    }
}
