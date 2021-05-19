package util.tuples;

public class ThreeTuple<A,B,C> extends TwoTuple<A,B> implements Comparable{
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + third.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ThreeTuple &&
                first.equals(((ThreeTuple<?, ?, ?>) o).first) &&
                second.equals(((ThreeTuple<?, ?, ?>) o).second) &&
                third.equals(((ThreeTuple<?, ?, ?>) o).third);
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ThreeTuple)) throw new ClassCastException();
        return Integer.compare(hashCode(),o.hashCode());
    }
}
