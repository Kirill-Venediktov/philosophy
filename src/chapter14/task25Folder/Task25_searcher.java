package chapter14.task25Folder;

import chapter14.Task25;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task25_searcher {
    static void callHiddenMethod(Object o, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method g = o.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(o);
    }
    public static void main(String[] args) {
        Task25 task25 = new Task25();
        task25.f();
        try {
            callHiddenMethod(task25, "g");
            callHiddenMethod(task25, "h");
            callHiddenMethod(task25, "j");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
