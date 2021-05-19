package chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFileTask16 {
    static String file =
            "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++)
            System.out.println("Value" + i + ": " + rf.readDouble());
        System.out.println(rf.readBoolean());
        System.out.println(rf.readByte());
        System.out.println(rf.readChar());
        System.out.println(rf.readFloat());
        System.out.println(rf.readInt());
        System.out.println(rf.readLong());
        System.out.println(rf.readShort());
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++)
            rf.writeDouble(i*1.414);
        rf.writeBoolean(false);
        rf.writeByte(4);
        rf.writeChar('g');
        rf.writeFloat(5f);
        rf.writeInt(90);
        rf.writeLong(900L);
        rf.writeShort(2);
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5*8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
