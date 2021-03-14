package chapter16;

import java.util.Arrays;

public class Task2 {
    public static BerylliumSphere[] madeMeArray(int size) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[size];
        for (int i = 0; i < size; i++) {
            berylliumSpheres[i] = new BerylliumSphere();
        }
        return berylliumSpheres;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(madeMeArray(-5)));
    }
}
