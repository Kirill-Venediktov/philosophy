package chapter18.task25;

import java.nio.ByteBuffer;

public class GetDataTask25 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        long start = System.nanoTime();
        ByteBuffer bb = ByteBuffer.allocateDirect(BSIZE);
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                System.out.print("nonzero");
        System.out.println("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();
        bb.rewind();
        bb.asShortBuffer().put((short) 471142);
        System.out.println(bb.getShort());
        bb.rewind();
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        bb.rewind();
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        bb.rewind();
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();
        long finish = System.nanoTime() - start;
        System.out.println("Времени потребовалось: " + finish + " нс");
    }
}
