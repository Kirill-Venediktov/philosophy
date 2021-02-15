package chapter10;

public class Task24 {
    public Task24() {
        System.out.println("Task24");
    }

    class Inner{
        int a;
        int b;

        public Inner(int a, int b) {
            this.a = a;
            this.b = b;
            System.out.println("Inner");
        }
    }
}

class Task24_1{

    public Task24_1() {
        System.out.println("Task24_1");
    }

    class AnotherInner extends Task24.Inner{
        public AnotherInner(Task24 task24, int a, int b){
            task24.super(a,b);
        }
    }
}
