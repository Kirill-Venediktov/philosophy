package chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task25 {
    public static void main(String[] args) {
        int[] aList = {1,2,3,4,5};
        System.out.println(aList.getClass().getSimpleName());
        System.out.println(Arrays.toString(aList));
        System.out.println(aList[4]);
        System.out.println("-----------");
        List<Integer> aList2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(aList2.getClass().getSimpleName());
        System.out.println(aList2);
        System.out.println(aList2.get(4));
        aList2.add(6);
        Collections.addAll(aList2, 7,8);
        System.out.println(aList2);
        ArrayList<Integer> aSlice = new ArrayList<>(Arrays.asList(aList2.get(3),aList2.get(4)));
        System.out.println(aSlice);
        System.out.println("---------");
        MyList<Integer> list2 = new MyList<>();
        list2.addAll(aList2);
        System.out.println(list2.getReversed());
    }
}

class MyList<T> extends ArrayList<T> {

    public ArrayList<T> getReversed() {
        ArrayList<T> reversed = new ArrayList<>();
        for (int i = (this.size() -1 ); i > -1; i--) {
            reversed.add(this.get(i));
        }
        return reversed;
    }
}