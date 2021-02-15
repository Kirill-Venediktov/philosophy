package chapter11;

import chapter6_1.Task1;

import java.util.*;

public class Task11 {
   public static void showMeString(Collection collection){
        Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + " ");
        }
       System.out.println();
    }

    public static void main(String[] args) {
        List<Task7> arrayList = new ArrayList<>();
        List<Task7> linkedList = new LinkedList<>();
        Set<Task7> hashSet = new HashSet<>();
        Set<Task7> treeSet = new TreeSet<>();

        for(int i = 0; i< 15; i++){
            Task7 task7 = new Task7(i);
            arrayList.add(task7);
            linkedList.add(task7);
            hashSet.add(task7);
//            treeSet.add(new Task7(i));
            treeSet.add(task7);
        }

        showMeString(arrayList);
        showMeString(linkedList);
        showMeString(hashSet);
        showMeString(treeSet);
    }
}
