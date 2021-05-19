package chapter16;

import java.util.Arrays;

public class Task18 {
    public static void main(String[] args) {
        BerylliumSphere[] b1 = new BerylliumSphere[5];
        BerylliumSphere[] b2 = new BerylliumSphere[10];
        for (int i = 0; i < b1.length; i++) {
            b1[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(b2));
        System.out.println("--------------");
        System.arraycopy(b1,0,b2,0, b1.length);
        System.out.println(Arrays.toString(b2));
        System.out.println("-----------");
        Arrays.sort(b1);
        System.out.println(Arrays.toString(b1));
        Arrays.sort(b1, new BerylliumSphereComparator());
        System.out.println(Arrays.toString(b1));

    }
}
