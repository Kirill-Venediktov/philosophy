package chapter17;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task42 implements Comparable<Task42> {
    private String string1;
    private String string2;

    public Task42(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    @Override
    public int compareTo(Task42 task42) {
        return string1.compareToIgnoreCase(task42.getString1());
    }

    @Override
    public String toString() {
        return "Task42{" +
                "string1='" + string1 + '\'' +
                ", string2='" + string2 + '\'' +
                '}';
    }
}

class Task42Test {
    public static void main(String[] args) {
        Task42[] task42sArray = new Task42[10];
        ArrayList<Task42> task42ArrayList = new ArrayList<>();
        RandomGenerator.String srg = new RandomGenerator.String();
        Task42Comp comp = new Task42Comp();

        for (int i = 0; i < task42sArray.length; i++){
            Task42 task42 = new Task42(srg.next(),srg.next());
            task42sArray[i] = task42;
            task42ArrayList.add(task42);
        }

        for (int i = 0; i < task42sArray.length; i++){
            System.out.print(task42sArray[i]);
        }
        System.out.println(task42ArrayList);
        System.out.println("---------------");
        System.out.println("Array sort:");
        Arrays.sort(task42sArray);
        for (int i = 0; i < task42sArray.length; i++){
            System.out.print(task42sArray[i]);
        }
        System.out.println("ArrayList sort:");
        Collections.sort(task42ArrayList);
        System.out.println(task42ArrayList);
        System.out.println("-----------------------");
        System.out.println("using comparator");
        System.out.println("Array sort:");
        Arrays.sort(task42sArray, comp);
        for (int i = 0; i < task42sArray.length; i++){
            System.out.print(task42sArray[i]);
        }
        System.out.println();
        System.out.println("ArrayList sort:");
        Collections.sort(task42ArrayList, comp);
        System.out.println(task42ArrayList);
        System.out.println("-------------");
        System.out.println("binary search");
        System.out.println("Array:");
        Task42 forSearch = task42sArray[1];
        System.out.println(Arrays.binarySearch(task42sArray,forSearch, comp));
        System.out.println("ArrayList");
        System.out.println(Collections.binarySearch(task42ArrayList,forSearch, comp));

    }
}

class Task42Comp implements Comparator<Task42>{

    @Override
    public int compare(Task42 t1, Task42 t2) {
        return t1.getString2().compareToIgnoreCase(t2.getString2());
    }
}

