package chapter9;

public abstract class Task4 {
    public abstract void f();
}

class Task4_1 extends Task4 {
    public void f(){
        System.out.println("f()");
    }

    public static void g(Task4 task4){
        task4.f();
    }

    public static void main(String[] args) {
        Task4_1 task4_1 = new Task4_1();
        g(task4_1);
    }
}