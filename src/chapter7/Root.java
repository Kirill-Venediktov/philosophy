package chapter7;

class Component1{
    public Component1(int i){
        System.out.println("Component1 is created");
    }
}

class Component2{
    public Component2(int i){
        System.out.println("Component2 is created");
    }
}

class Component3{
    public Component3(int i){
        System.out.println("Component3 is created");
    }
}

public class Root {
    Component1 component1 = new Component1(55);
    Component2 component2 = new Component2(99);
    Component3 component3 = new Component3(77);

    public Root(int i) {
        System.out.println("Root is created");
    }
}

class Stem extends Root{
    Component1 component1 = new Component1(44);
    Component2 component2 = new Component2(55);
    Component3 component3 = new Component3(66);
    public Stem(int i){
        super(i);
        System.out.println("Stem is created");
    }

    public static void main(String[] args) {
        Stem stem = new Stem(1);
    }
}
