package chapter4;

import java.util.ArrayList;

public class Fibonacci {
    static void start(int i){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int j = 1; j < i+1; j++){
            int summ = 0;
            switch (j){
                case (1):
                case (2):
                    integers.add(1);
                    System.out.println(integers);
                    continue;
                default:
                    summ = integers.get(j-2) + integers.get(j-3);
                    integers.add(summ);
                    System.out.println(integers);
                    continue;
            }
        }
    }

    public static void main(String[] args) {
       start(8);
    }
}
