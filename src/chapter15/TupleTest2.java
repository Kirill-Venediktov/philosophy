package chapter15;

import chapter7.Amphibian;
import util.tuples.*;

import static util.tuples.Tuple.tuple;

public class TupleTest2 {
    static TwoTuple<String, Integer> f(){
        return tuple("hi", 47);
    }
    static TwoTuple f2() {
        return tuple("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(),"hi", 47);
    }
    static FourTuple<Long, Amphibian, String, Integer> h() {
        return tuple(5l, new Amphibian(),"hi", 47);
    }
    static FiveTuple<Long, Amphibian, String, Integer, Double> k() {
        return tuple(5l, new Amphibian(), "hi", 47, 5.6);
    }
    static SixTuple<Long, Amphibian, String, Integer, Double, Boolean> l() {
        return tuple(7l,new Amphibian(), "hi", 47, 5.5, true);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(l());

        System.out.println();
        TwoTuple<String, Integer> ttsi2 = f2();
        System.out.println(ttsi2);
    }
}
