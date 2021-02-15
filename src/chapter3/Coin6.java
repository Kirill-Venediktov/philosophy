package chapter3;

import java.util.Random;

public class Coin6 {
    void cast(){
        Random random = new Random();
        int a = random.nextInt(10);
        System.out.println(a);
        if (a<5){
            System.out.println("Орел");
        }else if(a>5){
            System.out.println("Решка");
        }else {
            System.out.println("Ребро");
        }
    }

    public static void main(String[] args) {
        Coin6 coin6 = new Coin6();
        coin6.cast();
    }
}
