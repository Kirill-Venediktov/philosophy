package chapter18;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Task12 {
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

    public static void write (String filename, LinkedList<String> list) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);
        ListIterator<String> iterator = list.listIterator();
        int lineCount = 1;
        while(iterator.hasNext()){
            String s = iterator.next();
            out.println(lineCount++ + ": " + s);
        }
        out.close();
    }

    public static void main(String[] args) {
        LinkedList<String> strings;
        try {
            strings = Task12.read(args[0]);
            Task12.write(
                    "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\Task12Out.txt", strings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Task12.reverse(strings);
    }
}
