package chapter16;

import util.CountingGenerator;

import java.util.Arrays;

public class Task12 {
    public static void main(String[] args) {
        double[] doubles = new double[5];
        CountingGenerator.Double d = new CountingGenerator.Double();
        for (int i = 0; i < doubles.length; i++){
            doubles[i] = d.next();
        }
        System.out.println(Arrays.toString(doubles));
    }
}
