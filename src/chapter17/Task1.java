package chapter17;

import util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Countries.names(10));
        List<String> names2 = new LinkedList<>(Countries.names(10));
        System.out.println(names);
        System.out.println(names2);

        for (int i = 0; i < 5; i++) {
            System.out.println("------i = " + i + " ---------");
            Collections.shuffle(names);
            Collections.shuffle(names2);
            System.out.println(names);
            System.out.println(names2);
        }
    }
}
