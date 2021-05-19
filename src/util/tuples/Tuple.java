package util.tuples;

public class Tuple {
    public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
        return new TwoTuple<A,B>(a,b);
    }
    public static <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b, C c) {
        return new ThreeTuple<A,B,C>(a,b,c);
    }
    public static <A,B,C,D>FourTuple<A,B,C,D> tuple (A a, B b, C c, D d) {
        return new FourTuple<A,B,C,D>(a,b,c,d);
    }
    public static <A,B,C,D,E> FiveTuple<A,B,C,D,E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple<A,B,C,D,E>(a,b,c,d,e);
    }
    public static <A,B,C,D,E,F> SixTuple<A,B,C,D,E,F> tuple(A a, B b, C c, D d, E e, F f) {
        return new SixTuple<A,B,C,D,E,F>(a,b,c,d,e,f);
    }

    public static void main(String[] args) {
        Tuple t = new Tuple();
        TwoTuple<Integer,Integer> t1 = tuple(1,3);
        ThreeTuple<Integer,Integer,Integer> t2 = tuple(1,2,4);
        TwoTuple<Integer, Integer> t3 = tuple(1,3);
        TwoTuple<Integer, Integer> t4 = tuple(1,4);
        SixTuple<Integer,Integer,Integer, Integer, Integer, Integer> t6 = tuple(1,2,3,4,5,6);
        SixTuple<Integer,Integer,Integer, Integer, Integer, Integer> t66 = tuple(1,2,3,4,5,6);
        SixTuple<Integer,Integer,Integer, Integer, Integer, Integer> t666 = tuple(2,4,5,7,9,8);
        System.out.println(t1.compareTo(t3));
        System.out.println(t6.compareTo(t66));
        System.out.println(t666.compareTo(t6));
    }
}
