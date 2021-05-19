package util.tuples;

public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> implements Comparable{
    public final E fifth;

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth);
        this.fifth = fifth;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + fifth.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FiveTuple &&
                first.equals(((FiveTuple<?,?,?,?,?>) o).first) &&
                second.equals(((FiveTuple<?,?,?,?,?>) o).second) &&
                third.equals(((FiveTuple<?,?,?,?,?>) o).third) &&
                fourth.equals(((FiveTuple<?,?,?,?,?>) o).fourth) &&
                fifth.equals(((FiveTuple<?, ?, ?, ?, ?>) o).fifth);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof FiveTuple)) throw new ClassCastException();
        return Integer.compare(hashCode(),o.hashCode());
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                ", fifth=" + fifth +
                '}';
    }
}
