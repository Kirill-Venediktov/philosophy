package chapter16;

import util.CountingGenerator;

import java.util.Arrays;

public class Task14 {
    public static int size = 10;
    static boolean[] booleans = new boolean[size];
    static byte[] bytes = new byte[size];
    static char[] chars = new char[size];
    static short[] shorts = new short[size];
    static int[] ints = new int[size];
    static long[] longs = new long[size];
    static float[] floats = new float[size];
    static double[] doubles = new double[size];

    public static void fillArrays() {
        CountingGenerator.Boolean boolg = new CountingGenerator.Boolean();
        CountingGenerator.Byte bg = new CountingGenerator.Byte();
        CountingGenerator.Character cg = new CountingGenerator.Character();
        CountingGenerator.Short sg = new CountingGenerator.Short();
        CountingGenerator.Integer ig = new CountingGenerator.Integer();
        CountingGenerator.Long lg = new CountingGenerator.Long();
        CountingGenerator.Float fg = new CountingGenerator.Float();
        CountingGenerator.Double dg = new CountingGenerator.Double();

        for (int i = 0; i < size; i++) {
            booleans[i] = boolg.next();
            bytes[i] = bg.next();
            chars[i] = (char)cg.next();
            shorts[i] = sg.next();
            ints[i] = ig.next();
            longs[i] = lg.next();
            floats[i] = fg.next();
            doubles[i] = dg.next();
        }
    }

    public static void showArrays() {
        System.out.println(Arrays.toString(booleans));
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(shorts));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(longs));
        System.out.println(Arrays.toString(floats));
        System.out.println(Arrays.toString(doubles));
    }

    public static void main(String[] args) {
        showArrays();
        fillArrays();
        System.out.println("-----------");
        showArrays();
    }
}
