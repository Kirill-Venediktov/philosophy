package chapter7;

public class Task13 {
    public void f(){
        System.out.println("f()");
    }
    public void f(int i){
        System.out.println("f(int)");
    }
    public void f(char c){
        System.out.println("f(char)");
    }
}

class Task13_2 extends Task13 {
    public void f(String s){
        System.out.println("f(String)");
    }

    public static void main(String[] args) {
        Task13_2 task13_2 = new Task13_2();
        task13_2.f();
        task13_2.f("gggg");
        task13_2.f(5);
        task13_2.f('c');
    }
}
