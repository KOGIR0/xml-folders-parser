package comparator;

public class RegexComparator extends Comparator {
    @Override
    public Boolean compare(String s) {
        return s.matches(this.searchValue);
    }
}
