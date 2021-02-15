package chapter3;

public class Task2 {
    float f1;

    public static void main(String[] args) {
        Task2 task1 = new Task2();
        Task2 task2 = new Task2();
        task1.f1 = 7.8f;
        task2.f1 = 8.7f;

        System.out.println(task1.f1);
        System.out.println(task2.f1);

        task1.f1 =task2.f1;
        System.out.println(task1.f1);
        System.out.println(task2.f1);

        task1.f1 = 4.4f;
        System.out.println(task1.f1);
        System.out.println(task2.f1);

        task1 = task2;

        System.out.println(task1.f1);
        System.out.println(task2.f1);

        task1.f1 = 9.9f;
        System.out.println(task1.f1);
        System.out.println(task2.f1);

    }
}

class PassObject{
    static void f(Task2 task2){
        task2.f1 = 0.0f;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.f1 = 4.4f;
        System.out.println(task2.f1);
        f(task2);
        System.out.println(task2.f1);
    }
}
