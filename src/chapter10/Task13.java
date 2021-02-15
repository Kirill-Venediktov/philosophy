package chapter10;

public class Task13 {
    public Task11Inerface f(){
        return new Task11Inerface() {
            void g(){
                System.out.println("g()");
            }
        };
    }

    public static void main(String[] args) {
        Task13 task13 = new Task13();

    }
}
