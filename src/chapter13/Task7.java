package chapter13;

import java.util.regex.Pattern;

public class Task7 {

    public static void main(String[] args) {
        String s ="tривет, я строка. gggg";

        System.out.println(Pattern.matches("^[a-z[а-я]].+[\\.]$",s));

    }
}
