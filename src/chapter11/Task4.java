package chapter11;

import java.util.*;

enum Names{
    МАРТИ, ДОК, ТАЙЛЕР, БИФ, КРЭШ, КОКО, КОРТЕКС
}

public class Task4 {
    private static int count = 0;

    static void resetToDefault(){
        count = 0;
    }

    static String next(){
        switch (count){
            default:
            case 0:
                count++;
                return Names.МАРТИ.toString();
            case 1:
                count++;
                return Names.ДОК.toString();
            case 2:
                count++;
                return Names.ТАЙЛЕР.toString();
            case 3:
                count++;
                return Names.БИФ.toString();
            case 4:
                count++;
                return Names.КРЭШ.toString();
            case 5:
                count++;
                return Names.КОКО.toString();
            case 6:
                count=0;
                return Names.КОРТЕКС.toString();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        LinkedList<String>stringLinkedList = new LinkedList<>();
        Set<String> stringSet = new HashSet<>();
        Set<String>stringLinkedHashSet = new LinkedHashSet<>();
        Set<String>stringTheeSet = new TreeSet<>();

        resetToDefault();
        for (int i = 0; i<10; i++){
            stringArrayList.add(next());
        }
        resetToDefault();
        for (int i = 0; i<10; i++){
            stringLinkedList.add(next());
        }
        resetToDefault();
        for (int i = 0; i<10; i++){
            stringSet.add(next());
        }
        resetToDefault();
        for (int i = 0; i<10; i++){
            stringLinkedHashSet.add(next());
        }
        resetToDefault();
        for (int i = 0; i<10; i++){
            stringLinkedHashSet.add(next());
        }
        resetToDefault();
        for (int i = 0; i<10; i++){
            stringTheeSet.add(next());
        }

        System.out.println(stringArrayList);
        System.out.println(stringLinkedList);
        System.out.println(stringSet);
        System.out.println(stringLinkedHashSet);
        System.out.println(stringTheeSet);

    }


}
