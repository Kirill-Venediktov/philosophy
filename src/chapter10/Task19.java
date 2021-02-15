package chapter10;

public interface Task19 {
    void g();
    void f();
    static class Inner{
        void method(Task19 task19){
            task19.f();
            task19.g();
        }
    }

    public static void main(String[] args) {
        Task19 task19 = new Task19_1();
        Task19.Inner inner = new Task19.Inner();
        inner.method(task19);
    }
}


class Task19_1 implements Task19{
    @Override
    public void g() {
        System.out.println("g");
    }

    @Override
    public void f() {
        System.out.println("f");
    }
}