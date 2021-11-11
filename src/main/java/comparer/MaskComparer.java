package comparer;

public class MaskComparer extends Comparer {
    @Override
    public Boolean compare(String s) {
        return s.contains(this.searchValue);
    }
}
