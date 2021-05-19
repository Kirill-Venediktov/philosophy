package chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JGrepChapter18Task26VarB {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> lines = new ArrayList<>();
        FileChannel fc = new FileInputStream(args[0]).getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, new File(args[0]).length());
        String encoding = System.getProperty("file.encoding");
        CharBuffer cb = (Charset.forName(encoding).decode(mbb));
        while (cb.hasRemaining()){
            char c = cb.get();
            sb.append(c);
            if ((c == '\n')){
                lines.add(sb.toString().trim());
                sb = new StringBuilder();
            }
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
