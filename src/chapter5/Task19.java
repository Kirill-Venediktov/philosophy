package chapter5;

public class Task19 {
    static void  f(String ... strings){
        for (String s : strings){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        f("Привет", "Сегодня", "Дождь", "Со снегом", "Иль нет");
        f(new String[]{"Hello", "My", "friend"});

    }
}
