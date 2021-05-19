package util.tuples;

public class TwoTuple <A,B> implements Comparable{
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
       return o instanceof TwoTuple &&
       first.equals(((TwoTuple<?, ?>) o).first) &&
       second.equals(((TwoTuple<?, ?>) o).second);
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof TwoTuple)) throw new ClassCastException();
        return Integer.compare(hashCode(),o.hashCode());
    }
}
