package chapter16;

import util.CountingGenerator;

import java.util.Arrays;

public class Task13 {
    public static void main(String[] args) {
        CountingGenerator.Character cg = new CountingGenerator.Character();
        char[] chars = new char[5];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = cg.next();
        }
        String string = new String(chars);
        System.out.println(string);

    }
}
