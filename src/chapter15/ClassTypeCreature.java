package chapter15;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class Building{

}

class House extends Building {

}

public class ClassTypeCreature<T> {
//    Class<T> kind;
    Map<String, Class<?>> map = new HashMap<>();

    public ClassTypeCreature(Class<T> kind) {
        map.put(kind.getSimpleName(),kind);
//        this.kind = kind;
    }

//    public ClassTypeCreature(Class<T> kind, Map<String, Class<?>> map) {
//        this.kind = kind;
//        this.map = map;
//    }

    public boolean f(Object arg) {
        if (map.get(arg.getClass().getSimpleName()) != null ){
            return true;
        }else {
            return false;
        }
    }

    public void addType(String typename, Class<?> kind) {
        map.put(typename, kind);
    }

    public T createNew(String typename) {
        try {
            if (map.get(typename) != null) {
                return (T) map.get(typename).getDeclaredConstructor().newInstance();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        ClassTypeCreature<Building> ctt1 =
                new ClassTypeCreature<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCreature<House> cttp2 =
                new ClassTypeCreature<>(House.class);
        System.out.println(cttp2.f(new Building()));
        System.out.println(cttp2.f(new House()));
    }
}
