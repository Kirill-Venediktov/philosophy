package chapter9.task16;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomChars implements Readable {
    private static Random random = new Random();
    private static final char[] capitals =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private int count;

    public RandomChars(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0){
            return -1;
        }
        cb.append(lowers[random.nextInt(lowers.length)] + " ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new RandomChars(10));
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
