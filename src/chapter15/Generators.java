package chapter15;

import chapter15.coffee.Coffee;
import chapter15.coffee.CoffeeGenerator;
import util.Generator;

import java.util.*;

public class Generators {
    public static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next()); }
        return coll;
    }

    public static <T>List<T> fill(List<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next()); }
        return coll;
    }

    public static <T> Queue<T> fill(Queue<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next()); }
        return coll;
    }

    public static <T>Set<T> fill(Set<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next()); }
        return coll;
    }

//    public static <? extends List> List fill(List coll, Generator<T> gen, int n) {
//        for (int i = 0; i < n; i++) {
//            coll.add(gen.next()); }
//        return coll;
//    }


    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(
                new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee c :coffee) {
            System.out.println(c);
        }
        Collection<Integer> fnumbers = fill(
                new ArrayList<Integer>(), new Fibbonacci(), 12
        );
        for (int i : fnumbers) {
            System.out.print(i + ", ");
        }
        System.out.println();
        List<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(),4);
        for (Coffee c :coffees) {
            System.out.println(c);
        }
        System.out.println();
        Set<Coffee> coffees2 = fill(new HashSet<>(), new CoffeeGenerator(),4);
        for (Coffee c :coffees2) {
            System.out.println(c);
        }
    }
}
