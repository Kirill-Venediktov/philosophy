package chapter17;

import java.util.ArrayList;
import java.util.Arrays;

public class Task32 {
    private int[] ints;
    int lastAdded;

    public Task32() {
        ints = new int[10];
    }

    public boolean add(int a) {
        boolean isAdded = false;
        if (lastAdded+1 == ints.length){
            int[] ints2 = Arrays.copyOf(ints, ints.length + 10);
            ints2[ints.length] = a;
            ints = ints2;
            lastAdded++;
            isAdded = true;
        }else {
            ints[lastAdded] = a;
            lastAdded++;
            isAdded = true;
        }return isAdded;
    }

    public int get (int index) {
        if (index < ints.length)
            return ints[index];
        else throw new ArrayIndexOutOfBoundsException();
    }

    public void clear() {
        ints = new int[10];
        lastAdded = 0;
    }
}

class Task32Test {

    public static long addTimeTest(Task32 list, int iter){
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.add(i);
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static long addTimeTest(ArrayList<Integer> list, int iter){
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.add(i);
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static long getTimeTest(Task32 list, int iter){
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.get(i);
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static long getTimeTest(ArrayList<Integer> list, int iter){
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++)
            list.get(i);
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Task32 task32 = new Task32();
        System.out.println("Add times (ns)");
        System.out.println("10");
        System.out.println("Task32: " + addTimeTest(task32, 10));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task32: " + addTimeTest(task32, 100));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 100));
        System.out.println("1 000");
        System.out.println("Task32: " + addTimeTest(task32, 1000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task32: " + addTimeTest(task32, 10000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10000));
        System.out.println("Get times (ns)");
        System.out.println("10");
        System.out.println("Task32: " + getTimeTest(task32, 10));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task32: " + getTimeTest(task32, 100));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 100));
        System.out.println("1000");
        System.out.println("Task32: " + getTimeTest(task32, 1000));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task32: " + getTimeTest(task32, 10000));
        System.out.println("ArrayList: " + getTimeTest(arrayList, 10000));
    }
}
