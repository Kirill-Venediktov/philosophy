package chapter10;

public class Task12 {
    public Task9Interface f(){
        return new  Task9Interface(){

            @Override
            public void f() {
                System.out.println("method");
            }
        };
    }
}
