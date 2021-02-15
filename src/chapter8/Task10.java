package chapter8;

public class Task10 {
    public void f() {
        g();
    }

    public void g(){

    }
}

class Task10_1 extends Task10 {
    @Override
    public void g() {
        System.out.println("Overrided second method");
    }

    public static void main(String[] args) {
        Task10 task10 = new Task10_1();
        task10.f();
    }
}