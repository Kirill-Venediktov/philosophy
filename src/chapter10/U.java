package chapter10;

public interface U {
    void f();
    void g();
    void s();
}

class A {
    U getU(){
        return new U() {
            @Override
            public void f() {
                System.out.println("f");
            }

            @Override
            public void g() {
                System.out.println("g");
            }

            @Override
            public void s() {
                System.out.println("s");
            }
        };
    }
}

class B{
    U[] us = new U[10];

    void saveU(U u){
        for (int i = 0; i < us.length; i++){
            if (us[i] == null){
                us[i] = u;
                break;
            }
        }
    }
    U deleteU(int position){
        U u = us[position];
        us[position] = null;
        return u;
    }

    void doU(){
        for(U u : us){
            u.f();
            u.g();
            u.s();
        }
    }

    public static void main(String[] args) {
        A[] as = new A[10];
        B b = new B();

        for (int i = 0; i< as.length; i++){
            as[i] = new A();
        }

        for (A a : as){
            b.saveU(a.getU());
        }

        b.doU();
        b.deleteU(3);
        b.deleteU(7);
    }

}