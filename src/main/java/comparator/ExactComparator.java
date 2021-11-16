package comparator;

public class ExactComparator extends Comparator {
    @Override
    public Boolean compare(String s) {
        return this.searchValue.equals(s);
    }
}
