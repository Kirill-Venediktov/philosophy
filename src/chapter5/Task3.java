package chapter5;

public class Task3 {
    Task3() {
        System.out.println("Hello, im class Test3");
    }

    Task3(String s){
        System.out.println("I'm class Test3, and string is " + s);
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        Task3 task31 = new Task3("ZZZonked");
    }

}
