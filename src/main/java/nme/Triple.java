package nme;

import java.util.Objects;

public class Triple<A, B, C> extends Pair<A, B> {
    public C third;

    public Triple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    public Triple() {
    }

    public void swapThird(Triple<?, ?, C> another) {
        C temp = third;
        third = another.third;
        another.third = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), third);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}
