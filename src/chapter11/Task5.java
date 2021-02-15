package chapter11;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> integers = NumbersAndStrings.integerArrayList(7);
        System.out.println("1: " + integers);
        int a = 9;
        integers.add(a);
        System.out.println("2: " + integers);
        System.out.println("3: " + integers.contains(a));
        integers.remove((Integer) a);
        int b = integers.get(2);
        System.out.println("4: " + b + " " + integers.indexOf(b));
        int c = 5;
        System.out.println("5: " + integers.indexOf(c));
        System.out.println("6: " + integers.remove(c));
        System.out.println("7: " + integers.remove(b));
        System.out.println("8: " + integers);
        integers.add(3, 8);
        System.out.println("9: " + integers);
        List<Integer> sub = integers.subList(1,4);
        System.out.println("Частичный список: " + sub);
        System.out.println("10: " + integers.containsAll(sub));
        Collections.sort(sub);
        System.out.println("После сортировки: " + sub);
        System.out.println("11: " + integers.containsAll(sub));
        Collections.shuffle(sub,random);
        System.out.println("После перемешивания: " + sub);
        System.out.println("12: " + integers.containsAll(sub));
        List<Integer> copy = new ArrayList<>(integers);
        sub = Arrays.asList(integers.get(1),integers.get(4));
        System.out.println("sub: " + sub);
        copy.removeAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<Integer>(integers);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1,8);
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17 " + copy);
        System.out.println("18: " + integers.isEmpty());
        integers.clear();
        System.out.println("19: " + integers);
        System.out.println("20: " + integers.isEmpty());
        integers.addAll(NumbersAndStrings.integerArrayList(4));
        System.out.println("21: " + integers);
        Object[] o = integers.toArray();
        System.out.println("22: " + o[3]);
        Integer[] pa = integers.toArray(new Integer[0]);


    }
}

class NumbersAndStrings {

    public static ArrayList<Integer> integerArrayList(int number){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i< number; i++){
            integers.add(i);
        }
        return integers;
    }

    public static ArrayList<String> stringArrayList(int number){
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i< number; i++){
            strings.add(Task4.next());
        }
        return strings;
    }
}

class Task6 {
    public static void main(String[] args) {
        Random random = new Random();
        List<String> strings = NumbersAndStrings.stringArrayList(7);
        System.out.println("1: " + strings);
        String a = Task4.next();
        strings.add(a);
        System.out.println("2: " + strings);
        System.out.println("3: " + strings.contains(a));
        strings.remove(a);
        String b = strings.get(2);
        System.out.println("4: " + b + " " + strings.indexOf(b));
        String c = Task4.next();
        System.out.println("5: " + strings.indexOf(c));
        System.out.println("6: " + strings.remove(c));
        System.out.println("7: " + strings.remove(b));
        System.out.println("8: " + strings);
        strings.add(3, Task4.next());
        System.out.println("9: " + strings);
        List<String> sub = strings.subList(1,4);
        System.out.println("Частичный список: " + sub);
        System.out.println("10: " + strings.containsAll(sub));
        Collections.sort(sub);
        System.out.println("После сортировки: " + sub);
        System.out.println("11: " + strings.containsAll(sub));
        Collections.shuffle(sub,random);
        System.out.println("После перемешивания: " + sub);
        System.out.println("12: " + strings.containsAll(sub));
        List<String> copy = new ArrayList<>(strings);
        sub = Arrays.asList(strings.get(1),strings.get(4));
        System.out.println("sub: " + sub);
        copy.removeAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<String>(strings);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1,Task4.next());
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17 " + copy);
        System.out.println("18: " + strings.isEmpty());
        strings.clear();
        System.out.println("19: " + strings);
        System.out.println("20: " + strings.isEmpty());
        strings.addAll(NumbersAndStrings.stringArrayList(4));
        System.out.println("21: " + strings);
        Object[] o = strings.toArray();
        System.out.println("22: " + o[3]);

    }



}