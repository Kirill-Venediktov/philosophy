package chapter15;

public class GenericMethods {
    public <Q,M> void  f (String x, Q y, M z) {
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("Hi", 100, 1.0);
    }
}
