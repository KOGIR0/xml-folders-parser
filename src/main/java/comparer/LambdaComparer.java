package comparer;

public class LambdaComparer extends Comparer {
    private Comparer comparer;

    public LambdaComparer(Comparer comparer) {
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
