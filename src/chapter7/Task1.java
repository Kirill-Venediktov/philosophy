package chapter7;

public class Task1 {
}

class Task1_test{
    Task1 task1;

    void f(){
        if (task1 == null){
            task1 = new Task1();
        }

        System.out.println(task1);
    }

    public static void main(String[] args) {
        Task1_test task1_test = new Task1_test();
        task1_test.f();
    }
}
