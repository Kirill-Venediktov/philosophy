package chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task12 {
    public static void main(String[] args) {
        List<Integer> integers1 = new ArrayList<>();
        List<Integer> integers2 = new ArrayList<>();

        for(int i = 0; i<10; i++){
            integers1.add(i);
        }

        ListIterator<Integer> iterator = integers1.listIterator(integers1.size());
        while (iterator.hasPrevious()){
            integers2.add(iterator.previous());
        }

        System.out.println(integers1);
        System.out.println(integers2);
    }
}
