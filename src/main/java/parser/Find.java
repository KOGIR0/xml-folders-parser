package parser;

public class Find extends NodeParser{
    Comparer comparer;

    public interface Comparer {
        public Boolean compare(String a);
    }

    public Find(Comparer c) {
        this.comparer = c;
    }

    @Override
    protected Boolean Compare(String s) {
        return this.comparer.compare(s);
    }
}
