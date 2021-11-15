package comparer;

public class RegexComparer extends Comparator {
    @Override
    public Boolean compare(String s) {
        return s.matches(this.searchValue);
    }
}
