package chapter18;

import util.BinaryFile;

import java.io.IOException;
import java.util.HashMap;

public class Task19 {
    public static void main(String[] args) throws IOException {
        String path =
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\Test1.txt";
        HashMap<Byte, Integer> bytes = new HashMap<>();

        byte[] ba = BinaryFile.read(path);
        for (byte b : ba) {
            if (!bytes.containsKey(b))
                bytes.put(b, 1);
            else{
                int a = bytes.get(b);
                a++;
                bytes.put(b,a);
            }
        }
        System.out.println(bytes);
    }
}
