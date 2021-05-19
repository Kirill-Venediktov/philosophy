package chapter17;

import util.Countries;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> aCountries = new HashMap<>();
        Set<String> setOfCountries = new HashSet<>();

        for (Map.Entry<String, String> entry : Countries.capitals().entrySet()) {
            if (entry.getKey().matches("^A\\w*")){
                setOfCountries.add(entry.getKey());
                aCountries.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println(aCountries);
        System.out.println(setOfCountries);
    }
}
