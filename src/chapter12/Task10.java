package chapter12;

public class Task10 {
    public static void g() throws MyException {
        throw new  MyException();
    }
    public static void f(){
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
       f();
    }
}
