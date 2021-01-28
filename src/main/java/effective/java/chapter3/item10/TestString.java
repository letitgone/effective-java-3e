package effective.java.chapter3.item10;

import java.util.Objects;

/**
 * @Author ZhangGJ
 * @Date 2021/01/28 08:29
 */
public class TestString {

    private String test;

    public String getTest() {
        return test;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof String) {
            return test.equalsIgnoreCase((String) o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(test);
    }

    public void setTest(String test) {
        this.test = test;
    }

    public TestString(String test) {
        this.test = test;
    }
}

