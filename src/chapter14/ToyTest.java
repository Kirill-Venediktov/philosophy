package chapter14;

import java.lang.reflect.InvocationTargetException;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Sings {}

class Toy {
    Toy() {
    }
    Toy(int i) {
        System.out.println("Hi");
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Sings {
    public FancyToy(int i) {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Имя класса: " + cc.getName() + " является интерфейсом? ["+ cc.isInterface() + "]");
        System.out.println("Простое имя: " + cc.getSimpleName());
        System.out.println("Каноническое имя : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {

        try {
            Toy.class.getDeclaredConstructor(int.class).newInstance(1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

//        Class c = null;
//        try {
//            c = Class.forName("chapter14.FancyToy");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Не удается найти FancyToy");
//            System.exit(1);
//        }
//        printInfo(c);
//        for (Class face : c.getInterfaces()){
//            printInfo(face);
//        }
//        Class up = c.getSuperclass();
//        Object obj = null;
//        try {
//            obj = up.newInstance();
//        } catch (InstantiationException e) {
//            System.out.println("Не удалось создать экземпляр");
//            System.exit(1);
//        } catch (IllegalAccessException e) {
//            System.out.println("Отказано в доступе");
//            System.exit(1);
//        }
//        printInfo(obj.getClass());
    }
}
