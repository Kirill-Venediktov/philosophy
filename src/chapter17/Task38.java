package chapter17;

import java.util.HashMap;

public class Task38 {

    public static long addTimeTest(HashMap<Integer,Integer> map, int iter) {
        map.clear();
        long start = System.nanoTime();
        for (int i= 0; i < iter; i++){
            map.put(i,i);
        }
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static long getTimeTest(HashMap<Integer,Integer> map, int iter){
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            map.get(i);
        }
        long stop = System.nanoTime();
        return (stop - start)/iter;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(500, 0.75f);
        System.out.println("10");
        System.out.println("AddTimeTest: " + addTimeTest(map, 10));
        System.out.println("GetTimeTest: " + getTimeTest(map, 10));
        System.out.println("100");
        System.out.println("AddTimeTest: " + addTimeTest(map, 100));
        System.out.println("GetTimeTest: " + getTimeTest(map, 100));
        System.out.println("1000");
        System.out.println("AddTimeTest: " + addTimeTest(map, 1000));
        System.out.println("GetTimeTest: " + getTimeTest(map, 1000));
        System.out.println("10000");
        System.out.println("AddTimeTest: " + addTimeTest(map, 10000));
        System.out.println("GetTimeTest: " + getTimeTest(map, 10000));
        HashMap<Integer,Integer> map2 = new HashMap<>(1500, 0.75f);
        System.out.println("---------------------------");
        System.out.println("10");
        System.out.println("AddTimeTest: " + addTimeTest(map2, 10));
        System.out.println("GetTimeTest: " + getTimeTest(map2, 10));
        System.out.println("100");
        System.out.println("AddTimeTest: " + addTimeTest(map2, 100));
        System.out.println("GetTimeTest: " + getTimeTest(map2, 100));
        System.out.println("1000");
        System.out.println("AddTimeTest: " + addTimeTest(map2, 1000));
        System.out.println("GetTimeTest: " + getTimeTest(map2, 1000));
        System.out.println("10000");
        System.out.println("AddTimeTest: " + addTimeTest(map2, 10000));
        System.out.println("GetTimeTest: " + getTimeTest(map2, 10000));
    }
}
