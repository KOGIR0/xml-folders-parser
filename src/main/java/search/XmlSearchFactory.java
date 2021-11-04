package search;

import constant.SearchType;

public class XmlSearchFactory {
    private XmlSearchFactory() {}

    public static FileSearchHandler getSearchHandler(SearchType type) {
        switch(type) {
            case Full -> { return new FullSearch(); }
            case Equals -> { return new ExactSearch(); }
            case Regular -> { return new RegexSearch(); }
            case Mask -> { return new MaskSearch(); }
            default -> { return new LambdaSearch((String s) -> false); }
        }
    }
}
