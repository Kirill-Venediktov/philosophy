package chapter17;

import java.util.ArrayList;
import java.util.Arrays;

public class Task31 {
    private String[] strings;

    public Task31() {
        strings = new String[10];
    }

    public boolean add(String s) {
        boolean isAdded = false;
        for (int i = 0; i < strings.length; i++){
            if (strings[i] == null){
                strings[i] = s;
                isAdded = true;
                break;
            }
            if (i == (strings.length - 1)){
                String[] strings2 = Arrays.copyOf(strings, strings.length + 10);
                strings2[strings.length] = s;
                strings = strings2;
                isAdded = true;
                break;
            }
        }
        return isAdded;
    }

    public String get (int index) {
        if (index < strings.length)
            return strings[index];
        return null;
    }

    public void clear() {
        strings = new String[10];
    }
}

class Task31Test {

    public static long addTimeTest(Task31 list, int iter){
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.add("hi");
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static long addTimeTest(ArrayList<String> list, int iter){
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.add("hi");
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static long getTimeTest(Task31 list, int iter){
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.get(i);
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static long getTimeTest(ArrayList<String> list, int iter){
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.get(i);
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Task31 task31 = new Task31();
        System.out.println("Add times (ns)");
        System.out.println("10");
        System.out.println("Task31: " + addTimeTest(task31, 10));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task31: " + addTimeTest(task31, 100));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 100));
        System.out.println("1 000");
        System.out.println("Task31: " + addTimeTest(task31, 1000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task31: " + addTimeTest(task31, 10000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10000));
        System.out.println("Get times (ns)");
        System.out.println("10");
        System.out.println("Task31: " + getTimeTest(task31, 10));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task31: " + getTimeTest(task31, 100));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 100));
        System.out.println("1000");
        System.out.println("Task31: " + getTimeTest(task31, 1000));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task31: " + getTimeTest(task31, 10000));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 10000));
    }
}
