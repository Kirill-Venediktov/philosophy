package chapter16;

import util.ConvertTo;
import util.Generated;
import util.Generator;
import util.RandomGenerator;

import java.util.Arrays;

public class Task22 {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(10);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[10], gen));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 10; i++) {
            int location = Arrays.binarySearch(a, i);
            if (location < 0) {
                System.out.println(i + " not found");
            }
        }

    }
}
