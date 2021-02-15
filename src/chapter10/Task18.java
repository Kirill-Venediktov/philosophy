package chapter10;

public interface Task18 {
    void f();
    static class Inner implements Task18{

        @Override
        public void f() {
            System.out.println("f()");
        }
    }

    public static void main(String[] args) {
        Task18 task18 = new Task18.Inner();
    }
}
