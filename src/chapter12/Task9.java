package chapter12;

class MyException9_1 extends Exception {

}

class MyException9_2 extends Exception {

}

class MyException9_3 extends Exception {

}


public class Task9 {
    public static void f() throws MyException9_1 {
        throw new MyException9_1();

    }

    public static void g() throws MyException9_2 {
        throw new MyException9_2();

    }

    public static void h() throws MyException9_3 {
        throw new MyException9_3();

    }

    public static  void i()  {
        throw new NullPointerException();
    }
    public static void main(String[] args) {
        try {
//            f();
//            g();
//            h();
            i();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Блок finally");
        }

    }
}

