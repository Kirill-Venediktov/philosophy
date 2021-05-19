package chapter18;

import java.io.*;

public class BasicFileOutputTask14 {
    static String fileWrite =
            "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\BasicFileOutput14.out";
    static String fileRead =
            "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\BasicFileOutput.java";
    public static void readWriteWithBuffer(BufferedReader in) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileWrite)));
        int lineCount = 1;
        String s;
        long start = System.nanoTime();
        while((s = in.readLine())!= null)
            out.println(lineCount++ + ": " + s);
        long finish = System.nanoTime() - start;
        out.close();
        System.out.println("С использованием буфера потрачено : " + finish + " нс.");
    }

    public static void readWriteWithoutBuffer(BufferedReader in) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileWrite));
        int lineCount = 1;
        String s;
        long start2 = System.nanoTime();
        while((s = in.readLine())!= null)
            out.println(lineCount++ + ": " + s);
        long finish2 = System.nanoTime() - start2;
        out.close();
        System.out.println("Без использования буфера потрачено :" + finish2 + " нс.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(fileRead)));
        readWriteWithBuffer(in);
        BufferedReader in2 = new BufferedReader(new StringReader(BufferedInputFile.read(fileRead)));
        readWriteWithoutBuffer(in2);


    }
}
