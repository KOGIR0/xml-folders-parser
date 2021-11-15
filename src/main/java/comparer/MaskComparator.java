package comparer;

public class MaskComparator extends Comparator {
    @Override
    public Boolean compare(String s) {
        return s.matches(this.searchValue);
    }
}
