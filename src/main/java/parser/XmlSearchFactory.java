package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlSearchFactory {
    private XmlSearchFactory() {}

    public static NodeParser getSearchHandler(SearchOptions so) {
        String str;
        switch(so.getSearchType()) {
            case Full:
                return new Find((String s) -> true);
            case Equals:
                str = so.getSearchValue();
                return new Find(str::equals);
            case Regular:
                str = so.getSearchValue();
                return new Find((String s) -> s.matches(str));
            case Mask:
                str = so.getSearchValue();
                return new Find((String s) -> s.contains(str));
            default:
                return new Find((String s) -> false);
        }
    }
}
