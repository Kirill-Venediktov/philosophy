package chapter13;

import java.util.Scanner;

public class Task20 {
    int anInt;
    long aLong;
    float aFloat;
    double aDouble;
    String string;

    public static void main(String[] args) {
        Task20 task20 = new Task20();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите int ");
        task20.anInt = scanner.nextInt();
        System.out.println("Введите aLong ");
        task20.aLong = scanner.nextLong();
        System.out.println("Введите Float ");
        task20.aFloat = scanner.nextFloat();
        System.out.println("Введите double ");
        task20.aDouble = scanner.nextDouble();
        System.out.println("Введите String");
        task20.string = scanner.next();

        System.out.println(task20.anInt);
        System.out.println(task20.aLong);
        System.out.println(task20.aFloat);
        System.out.println(task20.aDouble);
        System.out.println(task20.string);
    }
}
