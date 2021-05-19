package chapter16;

import util.CountingGenerator;
import util.Generated;

import java.util.Arrays;

public class Task15 {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[3];
        Generated.array(berylliumSpheres, new CountingGenerator.BerylliumSphere());
        System.out.println(Arrays.toString(berylliumSpheres));
        System.out.println("----------");
        BerylliumSphere[] a = Generated.array(BerylliumSphere.class, new CountingGenerator.BerylliumSphere(), 4);
        System.out.println(Arrays.toString(a));

    }
}
