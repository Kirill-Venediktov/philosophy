package chapter2;

public class ATypeNme3 {
    String string = "String for a type name";
    ATypeNme3(){
        System.out.println("Привет");
    }

    public static void main(String[] args) {
        ATypeNme3 aTypeNme3 = new ATypeNme3();
        System.out.println(aTypeNme3.string);
    }
}
