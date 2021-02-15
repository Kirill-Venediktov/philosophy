package chapter7;

import java.util.Random;

public class Task18 {
    private static Random random = new Random();
    public final int a = random.nextInt(20);
    public static int b = random.nextInt(20);
    public Task18(){
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        Task18 task = new Task18();
        Task18 task1 = new Task18();
    }
}
