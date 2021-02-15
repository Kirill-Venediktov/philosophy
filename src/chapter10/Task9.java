package chapter10;

interface Task9Interface{
    void f();
}

public class Task9 {
    public Task9Interface g(){
        class Task9_1 implements Task9Interface{
            @Override
            public void f() {
                System.out.println("Implements method");
            }
        }
        return new Task9_1();
    }
}
