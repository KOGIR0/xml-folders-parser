package comparer;

public class LambdaComparator extends Comparator {
    private Comparer comparer;

    public LambdaComparator(Comparer comparer) {
        this.comparer = comparer;
    }

    public interface Comparer {
        public Boolean compare(String a);
    }

    @Override
    public Boolean compare(String s) {
        return this.comparer.compare(s);
    }
}
