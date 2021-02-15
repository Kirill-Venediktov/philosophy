package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainException {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("123.exe");
        file.close();
    }
}
