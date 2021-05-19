package util.tuples;

public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> implements Comparable {
    public final D fourth;

    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + fourth.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FourTuple &&
                first.equals(((FourTuple<?,?,?,?>) o).first) &&
                second.equals(((FourTuple<?,?,?,?>) o).second) &&
                third.equals(((FourTuple<?,?,?,?>) o).third) &&
                fourth.equals(((FourTuple<?,?,?,?>) o).fourth);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof FourTuple)) throw new ClassCastException();
        return Integer.compare(hashCode(),o.hashCode());
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                '}';
    }
}
