package comparer;

public class MaskComparer extends Comparator {
    @Override
    public Boolean compare(String s) {
        return s.matches(this.searchValue);
    }
}
