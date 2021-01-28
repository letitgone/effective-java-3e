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

    private final String name;

    public CaseInsensitiveString(String s, String name) {
        this.s = Objects.requireNonNull(s);
        this.name = Objects.requireNonNull(name);
    }

    /**
     * 违反对称性
     *
     * @param o
     * @return
     */
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//        if (o instanceof String) {
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s
                .equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish", "test");
        CaseInsensitiveString cis1 = new CaseInsensitiveString("Poldish", "123");
        String s = "Polish";
        System.out.println(cis.equals(s));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(new TestString(s)));
    }
}
