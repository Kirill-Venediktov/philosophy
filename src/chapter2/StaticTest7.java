package chapter2;

public class StaticTest7 {
    static int stat = 77;
}

class Incrementable {
    static void increment(){
        StaticTest7.stat++;
    }

    public static void main(String[] args) {
        StaticTest7 staticTest1 = new StaticTest7();
        StaticTest7 staticTest7 = new StaticTest7();
        System.out.println(StaticTest7.stat);
        increment();
        System.out.println(StaticTest7.stat);
    }
}
