package chapter10;

public class Task7 {
    private String string = "PrivateString";

    private void f(){
        System.out.println("Private method");
    }

    public void innerStart(){
        Inner inner = new Inner();
        inner.g();
    }

    class Inner {
        public void g(){
            string = "I can change";
            f();
        }
    }

    public static void main(String[] args) {
        Task7 task7 = new Task7();
        System.out.println(task7.string);
        task7.innerStart();
        System.out.println(task7.string);
    }
}
