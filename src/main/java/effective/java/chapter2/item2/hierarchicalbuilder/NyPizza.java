package effective.java.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

/**
 * @Author ZhangGJ
 * @Date 2021/01/27 07:26
 */
public class NyPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}


    private final Size size;


    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "New York Pizza with " + toppings;
    }
}
