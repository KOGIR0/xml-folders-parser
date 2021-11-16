package comparator;

import constant.SearchType;

public class CompatorFactory {
    public static Comparator getComparer(SearchType type) {
        switch(type) {
            case Full -> { return new FullComparator(); }
            case Equals -> { return new ExactComparator(); }
            case Regular -> { return new RegexComparator(); }
            case Mask -> { return new MaskComparator(); }
            default -> { return new LambdaComparator((String s) -> false); }
        }
    }
}
