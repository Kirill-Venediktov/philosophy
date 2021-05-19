package chapter16;

import util.ConvertTo;
import util.CountingGenerator;
import util.Generated;
import util.SkipGenerator;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConvertTo.primitive(Generated.array(Boolean.class, new SkipGenerator.Boolean(true), size));
        System.out.println("a1 = " + Arrays.toString(a1));
        byte[] a2 = ConvertTo.primitive(Generated.array(Byte.class, new SkipGenerator.Byte((byte) 3), size));
        System.out.println("a2 = " + Arrays.toString(a2));
        char[] a3 = ConvertTo.primitive(Generated.array(Character.class, new SkipGenerator.Character(2),size));
        System.out.println("a3 = " + Arrays.toString(a3));
        short[] a4 = ConvertTo.primitive(Generated.array(Short.class, new SkipGenerator.Short((short) 2), size));
        System.out.println("a4 = " + Arrays.toString(a4));
        int[] a5 = ConvertTo.primitive(Generated.array(Integer.class, new SkipGenerator.Integer(45), size));
        System.out.println("a5 = " + Arrays.toString(a5));
        long[] a6 = ConvertTo.primitive(Generated.array(Long.class, new SkipGenerator.Long(65), size));
        System.out.println("a6 = " + Arrays.toString(a6));
        float[] a7 = ConvertTo.primitive(Generated.array(Float.class, new SkipGenerator.Float(4), size));
        System.out.println("a7 = " + Arrays.toString(a7));
        double[] a8 = ConvertTo.primitive(Generated.array(Double.class, new SkipGenerator.Double(3.4),size));
        System.out.println("a8 = " + Arrays.toString(a8));
        BigDecimal[] a9 = Generated.array(BigDecimal.class, new CountingGenerator.BigDecimal(), size);
        System.out.println("a9 = " + Arrays.toString(a9));
    }
}
