package comparer;

public class ExactComparer extends Comparer {
    @Override
    public Boolean compare(String s) {
        return this.searchValue.equals(s);
    }
}
