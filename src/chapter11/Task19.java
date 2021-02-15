package chapter11;

import java.util.*;

public class Task19 {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        Random random = new Random();
        for (int i = 0; i<10; i++){
            hashSet.add(Task18.getName());
        }
        System.out.println(hashSet);
        for (String s : hashSet){
            treeSet.add(s);
        }
        System.out.println(treeSet);

        for (String s : treeSet){
            linkedHashSet.add(s);
        }
        System.out.println(linkedHashSet);
    }
}
