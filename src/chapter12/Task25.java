package chapter12;

public class Task25 extends Exception{
}

class Task25_1 extends Task25{

}

class Task25_2 extends Task25_1{

}

class A {
    public void f() throws Task25 {
        throw new Task25();
    }
}

class B extends A {
    @Override
    public void f() throws Task25 {
        throw new Task25_1();
    }
}

class C extends B {
    @Override
    public void f() throws Task25 {
        throw new Task25_2();
    }

    public static void main(String[] args) {
        A a_c = new C();
        try {
            a_c.f();
        } catch (Task25 task25) {
            task25.printStackTrace();
        }
    }
}