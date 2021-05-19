package chapter17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task6 {
    static void test(String msg, List<String> list){
        System.out.println("---" + msg + "------");
        Collection<String> c = list;
        Collection<String> sublist = list.subList(1, 8);
    }
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
    }
}
