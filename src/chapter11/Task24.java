package chapter11;

import java.util.*;

public class Task24 {
    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("Ноутбук", "Черный");
        linkedHashMap.put("Коробочка", "Зеленая");
        linkedHashMap.put("Шкаф", "Желтый");
        linkedHashMap.put("Кровать", "Коричневая");
        linkedHashMap.put("Телевизор", "Серый");
        linkedHashMap.put("Одеяло", "Синее");

        System.out.println(linkedHashMap);

        TreeMap<String,String> sortMap = new TreeMap<>(linkedHashMap);

        linkedHashMap.clear();

        System.out.println(sortMap);

        for (Map.Entry<String, String> entry : sortMap.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(linkedHashMap);
    }

}
