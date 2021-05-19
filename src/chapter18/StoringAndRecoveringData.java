package chapter18;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String link =
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\Data.txt";

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(link)));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(link)));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
