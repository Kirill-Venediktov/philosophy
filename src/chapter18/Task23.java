package chapter18;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Task23 {
    private static final int BSIZE = 1024;

    public static boolean isAPrintedMark(char c) {
        return((c >= '!') && (c <= '~'));
    }

    public static void showAllOfYouCan(CharBuffer charBuffer) {
        charBuffer.rewind();
        while(charBuffer.hasRemaining()){
            char c = charBuffer.get();
            if (isAPrintedMark(c))
                System.out.println(c);
        }
    }



    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileInputStream(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\Test1.txt"
        ).getChannel();
//        CharBuffer buf = CharBuffer.allocate(BSIZE);
        ByteBuffer buf = ByteBuffer.allocate(BSIZE);
        fc.read(buf);
        buf.flip();
        showAllOfYouCan(buf.asCharBuffer());
//        System.out.println(buf.asCharBuffer());
        buf.rewind();
        String encoding = System.getProperty("file.encoding");
        showAllOfYouCan(Charset.forName(encoding).decode(buf));
//        System.out.println("Decoding using " + encoding + ": " + Charset.forName(encoding).decode(buf));
    }
}
