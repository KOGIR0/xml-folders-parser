package search;

public class LambdaSearch extends FileSearchHandler {
    Comparer comparer;

    public interface Comparer {
        public Boolean compare(String a);
    }

    public LambdaSearch(Comparer c) {
        this.comparer = c;
    }

    @Override
    protected Boolean Compare(String s) {
        return this.comparer.compare(s);
    }
}
