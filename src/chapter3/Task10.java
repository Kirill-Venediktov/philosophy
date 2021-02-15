package chapter3;

public class Task10 {


    public static void main(String[] args) {
        int i1 = 0x2f;
        int i2 = 0x5d;

        System.out.println(Integer.toBinaryString(i1));
        System.out.println(Integer.toBinaryString(i2));

        int i3 = i1&i2;
        int i4 = i1|i2;
        int i5 = i1^i2;
        int i6 = ~i1;

        System.out.println(Integer.toBinaryString(i3));
        System.out.println(Integer.toBinaryString(i4));
        System.out.println(Integer.toBinaryString(i5));
        System.out.println(Integer.toBinaryString(i6));
    }
}
