package chapter16;

import util.ConvertTo;
import util.Generated;
import util.Generator;
import util.RandomGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Task23 {
    public static void main(String[] args) {
//        Generator<Integer> gen = new RandomGenerator.Integer(100);
        Random random = new Random();
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new ReverseIntegerComparator());
        System.out.println(Arrays.toString(a));
    }
}

class ReverseIntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        return (i2.compareTo(i1));
    }
}
