package chapter17;

import util.RandomGenerator;

import java.util.*;

class Task41Test {
    public static void main(String[] args) {
        HashSet<Task40> set = new HashSet<>();
        HashMap<Task40, Integer> map = new HashMap<>();
        RandomGenerator.String srg = new RandomGenerator.String();
        Task40Comp comp = new Task40Comp();

        for (int i = 0; i < 10; i++){
            Task40 task40 = new Task40(srg.next(),srg.next());
            set.add(task40);
            map.put(task40, i);
        }

        System.out.println(set);
        System.out.println(map);

    }
}


