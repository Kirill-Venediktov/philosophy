package chapter17;

import util.Countries;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Set<String> countrySet1 = new HashSet<>(Countries.capitals().keySet());
        Set<String> countrySet2 = new LinkedHashSet<>(Countries.capitals().keySet());
        Set<String> countrySet3 = new TreeSet<>(Countries.capitals().keySet());
        for(int i = 0; i < 5; i++) {
            countrySet1.addAll(Countries.capitals().keySet());
            countrySet2.addAll(Countries.capitals().keySet());
            countrySet3.addAll(Countries.capitals().keySet());
        }
        System.out.println(countrySet1);
        System.out.println(countrySet2);
        System.out.println(countrySet3);
    }

}
