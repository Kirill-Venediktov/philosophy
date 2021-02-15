package chapter13;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    public static final String POEM =
            "Twas brilling, and slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves, \n" +
                    "And the mome raths outgrabe. \n\n" +
                    "Beware the Jabberwock, my son, \n" +
                    "The jaws that bite, the Claws that catch. \n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>();
        Matcher m = Pattern.compile("[A-Z]\\w+").matcher(POEM);
//                Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while (m.find()){
            for (int j = 0; j <= m.groupCount(); j++){
                System.out.println("[" + m.group(j) + "]");
                words.add(m.group(j));
            }
        }
        System.out.println("Количество уникальных слов: " + words.size());
    }
}
