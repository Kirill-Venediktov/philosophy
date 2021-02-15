package chapter5;

public class Task2 {
    String string = "Hello";
    int a;
    Task2(){
        a = 5;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        System.out.println(task2.a);
        System.out.println(task2.string);
    }
}
