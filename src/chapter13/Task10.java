package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 {

    public static void match(String regex, String s){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println("Match " + matcher.group() + " /at positions" +
                    matcher.start() + "-" + (matcher.end() - 1));
        }
//        System.out.println(Pattern.matches(regex,s));
    }

    public static void main(String[] args) {
        String s = "Java now has regular expressions";
        match("^Java", s);
        System.out.println("---------");
//        match("\Breg.*",s);
//       match("n.w\s+h(a|i)s", s);
        match("s?",s);
        System.out.println("--------");
        match("s*", s);
        System.out.println("--------");
        match("s+", s);
        System.out.println("------");
        match("s{4}",s);
        System.out.println("------");
        match("s{1}",s);
        System.out.println("------");
        match("s{0,3}",s);
    }
}
