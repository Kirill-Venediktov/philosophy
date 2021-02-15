package chapter13;

public class Task11 {
    public static void main(String[] args) {
        String s = "Arline ate eight apples and one orange while Anita hadn't any";

        Task10.match("(?i)((^[aeiou]))\\w+?[aeiou]\\b", s);
    }
}
