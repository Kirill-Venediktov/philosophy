package chapter5;

public class Test10 {

    Test10(){
        System.out.println("Hello");
    }

    public void finalize(){
        System.out.println("Сообщение");
    }

    public static void main(String[] args) {
        Test10 test10 = new Test10();
        test10.finalize();
    }
}
