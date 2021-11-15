package comparer;

import constant.SearchType;

public class ComparerFactory {
    public static Comparator getComparer(SearchType type) {
        switch(type) {
            case Full -> { return new FullComparer(); }
            case Equals -> { return new ExactComparer(); }
            case Regular -> { return new RegexComparer(); }
            case Mask -> { return new MaskComparer(); }
            default -> { return new LambdaComparer((String s) -> false); }
        }
    }
}
