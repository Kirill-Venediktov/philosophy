package chapter13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileName = in.toString();

        try {
            FileReader fileReader = new FileReader(fileName);
            int c;
//            char[] chars = new char[fileReader.read()]
            while ((c=fileReader.read())!=-1){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
