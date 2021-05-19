package util.tuples;

public class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E>{
    public final F sixth;

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth);
        this.sixth = sixth;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + sixth.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SixTuple &&
                first.equals(((FiveTuple<?,?,?,?,?>) o).first) &&
                second.equals(((FiveTuple<?,?,?,?,?>) o).second) &&
                third.equals(((FiveTuple<?,?,?,?,?>) o).third) &&
                fourth.equals(((FiveTuple<?,?,?,?,?>) o).fourth) &&
                fifth.equals(((FiveTuple<?, ?, ?, ?, ?>) o).fifth) &&
                sixth.equals(((SixTuple<?, ?, ?, ?, ?, ?>) o).sixth);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof SixTuple)) throw new ClassCastException();
        return Integer.compare(hashCode(),o.hashCode());
    }

    @Override
    public String toString() {
        return "SixTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                ", fifth=" + fifth +
                ", sixth=" + sixth +
                '}';
    }
}
