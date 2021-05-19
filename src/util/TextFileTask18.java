package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFileTask18 extends ArrayList<String> {
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
            BufferedReader in = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
                in.close();
        return sb.toString();
    }

    public static void write(String fileName, String text) throws FileNotFoundException {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
                out.print(text);
                out.close();

    }
    public TextFileTask18(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }
    public TextFileTask18(String fileName) throws IOException {
        this(fileName, "\n");
    }
    public void write(String fileName) throws FileNotFoundException {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
                for (String item : this)
                    out.println(item);
                out.close();
    }

    public static void main(String[] args) throws IOException {
        String file = read("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\TextFile.java");
        write("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\forTextFile\\test.txt", file);
        TextFileTask18 text = new TextFileTask18("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\forTextFile\\test.txt");
        text.write("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\forTextFile\\test2.txt");
        TreeSet<String> words = new TreeSet<>
                (new TextFileTask18("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\util\\TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));

    }
}
