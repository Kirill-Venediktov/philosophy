package chapter17;

import util.RandomGenerator;

import java.util.TreeSet;

public class Task9 {
    public static void main(String[] args) {
        TreeSet<String> strings = new TreeSet<>();
        RandomGenerator.String rs = new RandomGenerator.String();
        for (int i = 0; i < 10; i++) {
            strings.add(rs.next());
        }
        System.out.println(strings);
    }
}
