package effective.java.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author ZhangGJ
 * @Date 2021/01/28 08:04
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    //    @Override public boolean equals(Object o) {
    //        if (o instanceof CaseInsensitiveString)
    //            return s.equalsIgnoreCase(
    //                    ((CaseInsensitiveString) o).s);
    //        if (o instanceof String)  // One-way interoperability!
    //            return s.equalsIgnoreCase((String) o);
    //        return false;
    //    }

    // Demonstration of the problem (Page 40)
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(s));
    }

    // Fixed equals method (Page 40)
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s
                .equalsIgnoreCase(s);
    }
}
