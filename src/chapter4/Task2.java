package chapter4;

import java.util.Random;

public class Task2 {

    static void compare(){
        Random random = new Random();
        for (int i = 0; i<25; i++){
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            System.out.println("a = " + a + ", b = " + b);
            if (a>b){
                System.out.println("a bolshe b");
            }else if (a<b){
                System.out.println("a menshe b");
            }else {
                System.out.println("ravenstvo");
            }
        }
    }

    static void infinityCompare(){
        Random random = new Random();
        while (true){
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            System.out.println("a = " + a + ", b = " + b);
            if (a>b){
                System.out.println("a bolshe b");
            }else if (a<b){
                System.out.println("a menshe b");
            }else {
                System.out.println("ravenstvo");
            }
        }
    }


    public static void main(String[] args) {
        infinityCompare();
    }
}
