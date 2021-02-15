package chapter5;

public class Dog {
    void bark(){
        System.out.println("Просто лай");
    }

    void bark(String s, int a){
        System.out.println("Завывание");
    }

    void bark(int a, String s){
        System.out.println("Поскуливание");
    }

    void bark(char c){
        System.out.println("Вой");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.bark(5, "gt");
        dog.bark("ert", 5);
        dog.bark('c');
    }

}
