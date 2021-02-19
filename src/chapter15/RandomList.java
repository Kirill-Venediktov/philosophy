package chapter15;

import java.util.ArrayList;
import java.util.Random;

public class RandomList <T>{
    private ArrayList<T> storage = new ArrayList<>();
    private Random random = new Random(47);
    public void add (T item) {
        storage.add(item);
    }
    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("The quick brown fox jumped over " + "the lazy brown dog").split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(rs.select() + " ");
        }
        System.out.println();
        RandomList<Integer> ri = new RandomList<>();
        for (int s = 0; s < 10; s++) {
            ri.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(ri.select() + " ");
        }

        System.out.println();
                RandomList<Character> rc = new RandomList<>();
        char[] chars = new char[]{'a','b', 'c', 'd', 'e','f','g', 'h'};
        for (int c = 0; c < chars.length; c++) {
            rc.add(chars[c]);
        }

        for (int i = 0; i < 11; i++) {
            System.out.print(rc.select() + " ");
        }
    }
}
