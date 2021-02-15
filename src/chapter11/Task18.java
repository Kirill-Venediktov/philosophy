package chapter11;

import java.util.*;

enum Name{
    Ivan, Sergei, Uri, Semen, Petr, Vasili, Stas, Kirill, Roman, Anton
}

public class Task18 {

    static String getName(){
        Random random = new Random();
        switch (random.nextInt(10)){
            default:
            case 0: return Name.Ivan.toString();
            case 1: return Name.Sergei.toString();
            case 2: return Name.Uri.toString();
            case 3: return Name.Semen.toString();
            case 4: return Name.Petr.toString();
            case 5: return Name.Vasili.toString();
            case 6: return Name.Stas.toString();
            case 7: return Name.Kirill.toString();
            case 8: return Name.Roman.toString();
            case 9: return Name.Anton.toString();
        }
    }

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i<10; i++){
            int a = random.nextInt(10);
            System.out.println(a);
            map.put(a,getName());
        }
        System.out.println(map);
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        System.out.println(set);
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : set){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        System.out.println(linkedHashMap);
    }
}
