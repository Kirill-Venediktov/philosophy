package chapter16;

import java.util.Arrays;

class Task19Test implements Comparable<Task19Test>{
    private int a;

    public Task19Test(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return  false;
        }if (a == ((Task19Test)o).getA()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Task19Test{" +
                "a=" + a +
                '}';
    }

    @Override
    public int compareTo(Task19Test task19Test) {
        return (Integer.compare(getA(), task19Test.getA()));
    }
}

public class Task19 {
    public static void main(String[] args) {
        Task19Test[] task19Tests1 = new Task19Test[4];
        Task19Test[] task19Tests2 = new Task19Test[4];

        Arrays.fill(task19Tests1, new Task19Test(5));
        Arrays.fill(task19Tests2, new Task19Test(5));
        System.out.println(Arrays.equals(task19Tests1, task19Tests2));
        System.out.println("------task24----");
        int index = Arrays.binarySearch(task19Tests1, new Task19Test(5));
        if (index >= 0) {
            System.out.println("Finded at " + task19Tests1[index]);
        }else {
            System.out.println("Element not found");
        }
    }
}
