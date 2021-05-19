package chapter18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\TestEOF.java"
        )));
        while (in.available() != 0)
            System.out.println((char) in.readByte());
    }
}
