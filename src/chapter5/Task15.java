package chapter5;

public class Task15 {
    String string;
    {
        string = "Hello";
        System.out.println("Initialization complete");
    }

    Task15(){
        System.out.println("Constructor");
    }



    public static void main(String[] args) {
        Task15 task15 = new Task15();
        System.out.println(task15.string);
    }
}
