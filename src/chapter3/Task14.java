package chapter3;

public class Task14 {
    void method(String s1, String s2){
        System.out.println("-----------------");
        System.out.println(s1==s2);
        System.out.println(s1!=s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.length() > s2.length());
        System.out.println(s1.length() < s2.length());
    }

    public static void main(String[] args) {
        Task14 task14 = new Task14();
        task14.method("Сиськи","Письки");
        task14.method("Привет", "Пока");
        task14.method("Привет","Привет");
    }
}
