package chapter14;

import java.lang.reflect.Field;

class A{
    boolean d;
}

class B extends A {
    long c;

}

class C extends B {
    int a;
    String b;
}


public class Recusing {
    public static void recurse(Object o) {
        System.out.println(o.getClass().getCanonicalName());
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields){
            System.out.println(field);
        }
        while (o.getClass().getSuperclass() != null){
            System.out.println(o.getClass().getSuperclass().getCanonicalName());
            Field[] fields1 = o.getClass().getDeclaredFields();
            for (Field field : fields1){
                System.out.println(field);
            }
            try {
                o = o.getClass().getSuperclass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

//        try {
//            System.out.println(o.getClass().getSuperclass().getCanonicalName());
//            System.out.println(o.getClass().getSuperclass().getSuperclass().getCanonicalName());
//            System.out.println(o.getClass().getSuperclass().getSuperclass().getSuperclass().getCanonicalName());
//        }catch (NullPointerException e){
//            System.out.println("Суперкласса нет");
//        }
////
//
//        System.out.println(o.getClass().getSuperclass().getCanonicalName());
//        System.out.println(o.getClass().getSuperclass().getSuperclass().getCanonicalName());
//        System.out.println(o.getClass().getSuperclass().getSuperclass().getSuperclass().getCanonicalName());

    }

    public static void main(String[] args) {
        A a = new A();
        C c = new C();
        recurse(c);
        recurse(a);

    }
}
