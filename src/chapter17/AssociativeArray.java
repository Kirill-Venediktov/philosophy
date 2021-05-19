package chapter17;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import java.util.Properties;


public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }
    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        HashMap<String, String> map1 = new HashMap<>();
        TreeMap<String, String> map2 = new TreeMap<>();
        LinkedHashMap<String, String> map3 = new LinkedHashMap<>();
        map.put("sky", "blue");
        map1.put("sky", "blue");
        map2.put("sky", "blue");
        map3.put("sky", "blue");
        map.put("grass", "green");
        map1.put("grass", "green");
        map2.put("grass", "green");
        map3.put("grass", "green");
        map.put("ocean", "dancing");
        map1.put("ocean", "dancing");
        map2.put("ocean", "dancing");
        map3.put("ocean", "dancing");
        map.put("tree", "tail");
        map1.put("tree", "tail");
        map2.put("tree", "tail");
        map3.put("tree", "tail");
        map.put("earth", "brown");
        map1.put("earth", "brown");
        map2.put("earth", "brown");
        map3.put("earth", "brown");
        map.put("sun", "warm");
        map1.put("sun", "warm");
        map2.put("sun", "warm");
        map3.put("sun", "warm");
        map1.put("extra", "object");
        map2.put("extra", "object");
        map3.put("extra", "object");
        try {
            map.put("extra", "object");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("To many objects!");
        }
        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(map.get("ocean"));
        System.out.println(map1.get("sun"));
        System.out.println(map2.get("extra"));
        System.out.println(map3.get("earth"));
    }
}
