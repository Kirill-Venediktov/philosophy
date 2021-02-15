package chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Task17 {
    public static void main(String[] args) {
        Random random = new Random();
        Map<String, Gerbil> gerbilMap = new HashMap<>();
        for (int i = 0; i<30; i++){
            Gerbil gerbil = new Gerbil(random.nextInt(50));
            gerbilMap.put(gerbil.toString(),gerbil);
        }
        System.out.println(gerbilMap);
        Iterator<String> gerbilIterator = gerbilMap.keySet().iterator();
        while (gerbilIterator.hasNext()){
            String a = gerbilIterator.next();
            System.out.println(a);
            gerbilMap.get(a).pop();
        }
    }
}
