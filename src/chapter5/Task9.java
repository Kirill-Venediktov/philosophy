package chapter5;

public class Task9 {
    Task9(int a){
        System.out.println("Перегруженный контсруктор");
    }

    Task9(){
        this(8);
        System.out.println("Конструктор по умолчанию");
    }

    public static void main(String[] args) {
        Task9 task9 = new Task9();

    }
}
