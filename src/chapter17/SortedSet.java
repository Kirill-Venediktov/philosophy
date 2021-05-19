package chapter17;

import util.RandomGenerator;

import java.util.*;


public class SortedSet<T> extends LinkedList<T> {
    private Comparator<T> comparator;

    public SortedSet() {
    }

    public SortedSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Comparator<T> comparator() {
        return comparator;
    }

    public int compare(T t1, T t2) {
       return Integer.compare(t1.hashCode(), t2.hashCode());
    }

    @Override
    public boolean add(T t) {
        if (!(this.contains(t))) {
            if (this.size() != 0) {
                for (int i = 0; i < this.size(); i++) {
                    if (compare(t, this.get(i)) == -1) {
                        super.add(i, t);
                        return true;
                    }
                }
                super.add(t);
                return true;
            } else {
                super.add(t);
                return true;
            }
        }
        return false;
    }

    public SortedSet<T> subSet(T from, T to) {
        if (this.contains(from) && this.contains(to)){
            SortedSet<T> subset = new SortedSet<>();
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).equals(from)){
                    for (int j = i; j < this.size(); j++){
                        subset.add(this.get(j));
                        if (this.get(j).equals(to)){
                            break;
                        }
                    }
                }
            }
            return subset;
        }else {
            return null;
        }

    }

    public SortedSet<T> headSet(T to) {
        if (this.contains(to)){
            SortedSet<T> headSet = new SortedSet<>();
            for (int i = 0; i < this.size(); i++) {
                T t = this.get(i);
                if (t.equals(to)){
                    break;
                }else {
                    headSet.add(t);
                }
            }
            return headSet;
        }else {
            return null;
        }

    }

    public SortedSet<T> tailSet(T from) {
        if (this.contains(from)) {
            SortedSet<T> tailSet = new SortedSet<>();
            outerloop:
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).equals(from)) {
                    for (int j = i; j < this.size(); j++) {
                        tailSet.add(this.get(j));
                        if ((j+1) == this.size()){
                            break outerloop;
                        }
                    }
                }
            }
            return tailSet;
        }else return null;
    }

    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new SortedSet<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            sortedSet.add(r.nextInt(20));
        }
        System.out.println(sortedSet);
        SortedSet<String> strings = new SortedSet<>();
        RandomGenerator.String string = new RandomGenerator.String();
        for (int i = 0; i < 10; i++) {
            strings.add(string.next());
        }
        System.out.println(strings);
        System.out.println("---------");
        sortedSet.clear();
        for (int i = 10; i > 0; i--)
            sortedSet.add(i);
        System.out.println(sortedSet);
        System.out.println(sortedSet.subSet(7,5));
        System.out.println(sortedSet.headSet(3));
        System.out.println(sortedSet.tailSet(4));


    }

}
