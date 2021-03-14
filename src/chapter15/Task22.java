package chapter15;

import java.lang.reflect.InvocationTargetException;

class Task22TestClass{
    private String s;
    private int a;

    public Task22TestClass(String s, Integer a) {
        this.s = s;
        this.a = a;
    }

    @Override
    public String toString() {
        return "Task22TestClass{" +
                "s='" + s + '\'' +
                ", a=" + a +
                '}';
    }
}

public class Task22<T> {
    Class<T> kind;

    public Task22(Class<T> kind) {
        this.kind = kind;
    }

    public T create(String s, Integer a) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class[] cArg = new Class[2];
        cArg[0] = s.getClass();
        cArg[1] = a.getClass();
        return kind.getDeclaredConstructor(cArg).newInstance(s,a);
    }

    public static void main(String[] args) {
      Task22<Task22TestClass> task22 = new Task22<>(Task22TestClass.class);
        try {
            Task22TestClass test = task22.create("Hi", 56);
            System.out.println(test);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
