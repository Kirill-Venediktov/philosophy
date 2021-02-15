package chapter12;

public class Task2 {
    private static Task2_1 task2_1;

    public static void main(String[] args) {
        try {
            task2_1.f();
        }catch (NullPointerException e){
            System.err.println("пойман NullPointerException");
            e.printStackTrace();
        }
    }
}

class Task2_1 {
    public void f(){
        System.out.println("Метод f()");
    }
}