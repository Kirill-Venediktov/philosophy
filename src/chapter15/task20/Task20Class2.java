package chapter15.task20;

public class Task20Class2 {
    public static  <T extends Task20Interface> void k(T x){
        x.f();
        x.g();
    }

    public static void main(String[] args) {
        Task20Class task20Class = new Task20Class();
        k(task20Class);
    }
}
