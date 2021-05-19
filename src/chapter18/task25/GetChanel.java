package chapter18.task25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class GetChanel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\data.txt")
                .getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes(StandardCharsets.UTF_8)));
        fc.close();
        fc = new RandomAccessFile(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\data.txt",
                "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        long start = System.nanoTime();
        fc = new FileInputStream("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\data.txt")
                .getChannel();
        ByteBuffer buff =ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
        System.out.println();
        long finish = System.nanoTime() - start;
        System.out.println("Затраченое время: " + finish + " нс");
    }
}
