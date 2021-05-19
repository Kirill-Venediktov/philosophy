package chapter18;

import util.TextFile;

import java.util.ArrayList;
import java.util.HashMap;

public class Task17 {
    public static void main(String[] args) {
        String file =
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\Test1.txt";
        String fileForWrite =
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\Task17.txt";
        HashMap<Character, Integer> signs = new HashMap<>();
        ArrayList<String> list = new ArrayList<>(new TextFile(file, ""));
        for (String s : list){
            char c = s.toCharArray()[0];
            if (!signs.containsKey(c)){
                signs.put(c,1);
            }else {
                int i = signs.get(c);
                i++;
                signs.put(c,i);
            }
        }
        System.out.println(list);
        System.out.println(signs);

    }

}
