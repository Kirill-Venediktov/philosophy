package chapter17;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task40 implements Comparable<Task40> {
    private String string1;
    private String string2;

    public Task40(String string1, String string2) {
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
    public int compareTo(Task40 task40) {
        return Integer.compare(string1.hashCode(), task40.string1.hashCode());
    }

    @Override
    public String toString() {
        return "Task40{" +
                "string1='" + string1 + '\'' +
                ", string2='" + string2 + '\'' +
                '}';
    }
}

class Task40Test {
    public static void main(String[] args) {
        Task40[] task40sArray = new Task40[10];
        ArrayList<Task40> task40ArrayList = new ArrayList<>();
        RandomGenerator.String srg = new RandomGenerator.String();
        Task40Comp comp = new Task40Comp();

        for (int i = 0; i < task40sArray.length; i++){
            Task40 task40 = new Task40(srg.next(),srg.next());
            task40sArray[i] = task40;
            task40ArrayList.add(task40);
        }

        for (int i = 0; i < task40sArray.length; i++){
            System.out.print(task40sArray[i]);
        }
        System.out.println(task40ArrayList);
        System.out.println("---------------");
        System.out.println("Array sort:");
        Arrays.sort(task40sArray);
        for (int i = 0; i < task40sArray.length; i++){
            System.out.print(task40sArray[i]);
        }
        System.out.println("ArrayList sort:");
        Collections.sort(task40ArrayList);
        System.out.println(task40ArrayList);
        System.out.println("-----------------------");
        System.out.println("using comparator");
        System.out.println("Array sort:");
        Arrays.sort(task40sArray, comp);
        for (int i = 0; i < task40sArray.length; i++){
            System.out.print(task40sArray[i]);
        }
        System.out.println();
        System.out.println("ArrayList sort:");
        Collections.sort(task40ArrayList, comp);
        System.out.println(task40ArrayList);
        System.out.println("-------------");
        System.out.println("binary search");
        System.out.println("Array:");
        Task40 forSearch = task40sArray[1];
        System.out.println(Arrays.binarySearch(task40sArray,forSearch, comp));
        System.out.println("ArrayList");
        System.out.println(Collections.binarySearch(task40ArrayList,forSearch, comp));

    }
}

class Task40Comp implements Comparator<Task40>{

    @Override
    public int compare(Task40 t1, Task40 t2) {
        return Integer.compare(t1.getString2().hashCode(), t2.getString2().hashCode());
    }
}

