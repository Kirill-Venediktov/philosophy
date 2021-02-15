package chapter7;

public class A {
    public A(int i) {
        System.out.println("Вызов конструктора А");
    }
}

class B {
    public B(int i){
        System.out.println("Вызов конструктора B");
    }
}

class C extends A {
    C(){
        super(55);
        System.out.println("Контсруктор С");
    }
    B b = new B(56);

    public static void main(String[] args) {
        C c = new C();
    }
}
