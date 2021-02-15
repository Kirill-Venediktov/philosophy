package chapter9;

public interface Task14 {
    void f();
    void g();
}

interface Task14_1 {
    void h();
    void i();
}

interface Task14_2 {
    void j();
    void k();
}

interface Task14_3 extends Task14, Task14_1, Task14_2 {
    void l();
}

abstract class ClassOne{
    abstract void methodOne();
}

class ClassTwo extends ClassOne implements Task14_3 {
    @Override
    public void f() {
        System.out.println("f()");
    }

    @Override
    public void g() {
        System.out.println("g()");
    }

    @Override
    public void h() {
        System.out.println("h()");
    }

    @Override
    public void i() {
        System.out.println("i()");
    }

    @Override
    public void j() {
        System.out.println("j()");
    }

    @Override
    public void k() {
        System.out.println("k()");
    }

    @Override
    public void l() {
        System.out.println("l()");
    }

    @Override
    void methodOne() {
        System.out.println("MethodOne");
    }
}

class Exploiter {
    static void a(Task14 x){
        x.f();
        x.g();
    }
    static void b(Task14_1 x) {
        x.h();
        x.i();
    }
   static void c(Task14_2 x) {
        x.k();
        x.j();
    }
   static void d(Task14_3 x) {
        x.l();
        a(x);
        b(x);
        c(x);
    }

    public static void main(String[] args) {
        ClassTwo classTwo = new ClassTwo();
        a(classTwo);
        b(classTwo);
        c(classTwo);
        d(classTwo);
    }
}