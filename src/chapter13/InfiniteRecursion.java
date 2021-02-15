package chapter13;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecursion adress: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }
}
