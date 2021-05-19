package chapter13;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrepChapter18Task26 {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> lines = new ArrayList<>();
        FileChannel fc = new FileInputStream(args[0]).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        String encoding = System.getProperty("file.encoding");
        while(fc.read(buff) != -1){
            fc.read(buff);
            buff.flip();
            CharBuffer cb = (Charset.forName(encoding).decode(buff));
            while (cb.hasRemaining()){
                char c = cb.get();
                sb.append(c);
                if ((c == '\n')){
                    lines.add(sb.toString().trim());
                    sb = new StringBuilder();
                }
            }
            buff.clear();
        }
        fc.close();
        if (!sb.isEmpty())
            lines.add(sb.toString());

        Pattern p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : lines) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
        }
    }
}
