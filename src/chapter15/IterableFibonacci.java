package chapter15;

import java.util.Iterator;

public class IterableFibonacci implements Iterable<Integer>{
    private int n;
    private Fibbonacci fibbonacci = new Fibbonacci();

    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibbonacci.next();
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)){
            System.out.print(i + " ");
        }
    }
}
