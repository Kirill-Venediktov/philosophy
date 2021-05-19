package chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputFileTask14 {
    public static String read(String filename) throws IOException {
        FileReader fin = new FileReader(filename);
        int a;
        StringBuilder sb = new StringBuilder();
        while ((a = fin.read())!= -1)
            sb.append((char) a);

        fin.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\BufferedInputFile.java"));
    }
}
