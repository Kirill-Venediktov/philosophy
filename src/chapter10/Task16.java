package chapter10;

public class Task16 {
    static class Inner{
        public Inner() {
            System.out.println("Im inner");
        }
    }

    public static void main(String[] args) {
        Inner inner = new Inner();
    }
}

class Task16_1{
    public static void main(String[] args) {
        Task16.Inner inner = new Task16.Inner();
    }
}