package chapter17;

import util.Countries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Task7 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Countries.names(15));
        LinkedList<String> linkedList = new LinkedList<>(Countries.names(15));
        Iterator<String> ai =  arrayList.iterator();
        Iterator<String> li = linkedList.iterator();
        ListIterator<String> lli = linkedList.listIterator();
        ListIterator<String> ali =arrayList.listIterator();


        while (ai.hasNext()){
            System.out.println(ai.next());
        }
        System.out.println("-------");
        while (li.hasNext()) {
            System.out.println(li.next());
        }
        System.out.println("------ADDING------");

        while (lli.hasNext()){
            lli.next();
            if (lli.hasNext()){
                lli.add(ali.next());
            }
        }
        System.out.println(linkedList);

        System.out.println("----REVERSE ADDING----");

        ali = arrayList.listIterator(arrayList.size());
        lli = linkedList.listIterator(0);
        while (ali.hasPrevious()) {
            ali.previous();
            if (ali.hasPrevious()){
                ali.add(lli.next());
                ali.previous();
            }
        }

        System.out.println(arrayList);
    }

}
