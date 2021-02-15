package chapter9;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String a = "Hello my friend";
        StringBuilder stringBuilder = new StringBuilder(a);
        System.out.println(stringBuilder);
        for (int i = 1; i<stringBuilder.length(); i+=2){
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(stringBuilder.charAt(i));
            stringBuilder1.append(stringBuilder.charAt(i-1));
            stringBuilder.replace(i-1,i+1,stringBuilder1.toString());
        }
        System.out.println(stringBuilder.toString());

    }

}
