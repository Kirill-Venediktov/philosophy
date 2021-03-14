package chapter15;

import java.util.Arrays;
import java.util.List;

class Fruit{}

class Apple extends Fruit {}

class Jonathan extends Apple{}

class Orange extends Fruit {}


public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        flist.contains(new Apple());
        flist.indexOf(new Apple());
    }
}
