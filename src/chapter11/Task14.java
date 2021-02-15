package chapter11;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task14 {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();

        for (int i = 0; i<15; i++){

            ListIterator<Integer> iterator = integers.listIterator(integers.size()/2);
            iterator.add(i);

//             if (integers.size() == 0){
//                integers.add(i);
//                continue;
//            }
//            ListIterator<Integer> forwardIterator = integers.listIterator();
//            ListIterator<Integer> revIterator = integers.listIterator(integers.size());
//
//            while (forwardIterator.hasNext() && revIterator.hasPrevious()){
//                if (forwardIterator.next() == revIterator.previous()){
//                    integers.add(integers.size()/2,i);
//                    continue;
//
//                }
//            }


//            integers.add(integers.size()/2, i);

//            ListIterator<Integer> iterator = integers.listIterator();
//
//            if (integers.size() == 0){
//                integers.add(i);
//                continue;
//            }
////            ListIterator<Integer> iterator = integers.listIterator(integers.size()/2);
////            iterator.next();
////            iterator.set(i);
//            ListIterator<Integer> forwardIterator = integers.listIterator();
//            ListIterator<Integer> revIterator = integers.listIterator(integers.size());
//            while (forwardIterator.hasNext()){
//                if (forwardIterator.next() == revIterator.previous()){
//                    integers.add(i);
//                }
//            }
        }
        System.out.println(integers);

    }
}
