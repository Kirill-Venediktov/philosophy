package chapter7;

public class Task3 {
    public Task3() {
        System.out.println("Task3 Constructor");
    }
}

class Task3_1 extends Task3 {

    public static void main(String[] args) {
        Task3_1 task3_1 = new Task3_1();
        Task15 task15 = new Task15();
        task15.f();
    }
}
