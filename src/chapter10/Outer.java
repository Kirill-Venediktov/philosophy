package chapter10;

public class Outer {
    private String string;
    public Outer() {
        string ="Hello";
        System.out.println("Outer");
    }
    class Inner{
        public Inner() {
            System.out.println("Inner");
        }

        @Override
        public String toString() {
            System.out.println(string);
            return string;
        }
    }

    public Inner getInner(){
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.getInner();
        inner.toString();
    }
}
