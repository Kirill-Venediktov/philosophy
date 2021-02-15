package chapter11;

import java.util.ArrayList;
import java.util.List;

public class Task7 implements Comparable<Task7> {
    private int a;

    public Task7(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Task7{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {
        Task7[] task7s = new Task7[5];
        for (int i = 0; i< task7s.length; i++){
            task7s[i] = new Task7(i);
        }
        List<Task7> task7s1 = new ArrayList<>();
        for (Task7 task7 : task7s){
            task7s1.add(task7);
        }
        System.out.println(task7s1);
        List<Task7> sub = task7s1.subList(1,4);
        System.out.println(sub);
        task7s1.removeAll(sub);
        System.out.println(task7s1);
    }

    @Override
    public int compareTo(Task7 o) {
        return a-o.a;
    }
}


