package util.tuples;

public class SixTuples<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E>{
    public final E sixth;

    public SixTuples(A first, B second, C third, D fourth, E fifth, E sixth) {
        super(first, second, third, fourth, fifth);
        this.sixth = sixth;
    }

    @Override
    public String toString() {
        return "SixTuples{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                ", fifth=" + fifth +
                ", sixth=" + sixth +
                '}';
    }
}
