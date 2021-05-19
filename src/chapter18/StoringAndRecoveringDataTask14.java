package chapter18;

import java.io.*;

public class StoringAndRecoveringDataTask14 {
    public static void main(String[] args) throws IOException {
        String link =
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\DataTask14.txt";

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(link)));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.writeBoolean(true);
        out.writeByte(3);
//        out.writeBytes("Bytes?");
        out.writeChar('c');
//        out.writeChars("Chars?");
        out.writeFloat(5f);
        out.writeInt(66);
        out.writeLong(76L);
        out.writeShort(2);


        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(link)));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readBoolean());
        System.out.println(in.readByte());
//        System.out.println(in.readByte());
        System.out.println(in.readChar());
//        System.out.println(in.readChar());
        System.out.println(in.readFloat());
        System.out.println(in.readInt());
        System.out.println(in.readLong());
        System.out.println(in.readShort());
        in.close();
    }
}
