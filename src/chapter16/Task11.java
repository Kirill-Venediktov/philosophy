package chapter16;

import java.util.Arrays;

public class Task11 {
    public static void main(String[] args) {
        Integer[] array = new Integer[5];
        int a = 3;
        array[0] = a;

        int[] ar = new int[4];
        Integer b = 4;
        ar[0] = b;

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ar));

        for (int i = 0; i < ar.length; i++) {
            array[i] = ar[i];
        }

        System.out.println(Arrays.toString(array));

//        ar =  array;
    }
}
