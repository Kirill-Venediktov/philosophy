package chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {

    public static Map<Integer, Integer> getStatisticMap(){
        Random random = new Random();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i< 1000; i++){
            int r = random.nextInt(30);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(getStatisticMap());
    }
}
