package chapter5;

public class Task8 {

    void method1(){
        System.out.println("Method 1");
    }
    void method2(){
        method1();
        this.method1();
    }

    public static void main(String[] args) {
        Task8 task8 = new Task8();
        task8.method2();
    }
}
