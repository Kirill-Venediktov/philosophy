package chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Task9 {
    public static LinkedList<String> read (String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> strings = new LinkedList<>();
        while ((s = in.readLine())!= null)
            strings.add(s);
        in.close();
        return strings;
    }
    public static void reverse (LinkedList<String> strings) {
        ListIterator<String> iterator = strings.listIterator(strings.size()-1);
        while(iterator.hasPrevious()){
            String s = iterator.previous();
            System.out.println(s);
        }
    }
    public static void format(LinkedList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String strToUpCase = strings.get(i).toUpperCase();
            strings.set(i,strToUpCase);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> strings;
        try {
            strings = Task9.read(args[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Task9.format(strings);
        Task9.reverse(strings);
    }
}
