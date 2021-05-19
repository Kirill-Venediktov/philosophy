package chapter18.task25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class BufferToTextTask25 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(BSIZE);
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoding using " + encoding + ": " + Charset.forName(encoding).decode(buffer));
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some Text".getBytes(StandardCharsets.UTF_16BE)));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocateDirect(24);
        buffer.asCharBuffer().put("Some Text");
        fc.write(buffer);
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        long finish = System.nanoTime() - start;
        System.out.println("Времени потребовалось: " + finish + " нс");

    }
}
