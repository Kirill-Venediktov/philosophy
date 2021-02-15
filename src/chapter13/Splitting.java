package chapter13;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forrest..." +
                    "with... a herring!";
    public static void split(String regex){
        System.out.println(
                Arrays.toString(knights.split(regex))
        );
    }

    public static void replaceAll(String regex, String replacement){
        String newString = knights.replaceAll(regex, replacement);
        System.out.println(newString);
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
        split("the");
        split("you");
        System.out.println("----------task9----------");
        replaceAll("[aeiouy]", "_");

    }
}
