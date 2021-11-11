package comparer;

public class RegexComparer extends Comparer {
    @Override
    public Boolean compare(String s) {
        return s.matches(this.searchValue);
    }
}
