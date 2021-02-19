package chapter12;

import java.lang.reflect.Array;

interface Selector {
    boolean end();
    Object current();
    void next();
}

class ArrayOverflowException extends RuntimeException{
    public ArrayOverflowException() {
    }

    public ArrayOverflowException(String message) {
        super(message);
    }
}

public class Sequence<T> {
    private T[] items;
    private int next = 0;
    public Sequence(int size) {
        items = (T[]) (new Object[size]);
    }
    public void add (T x) throws ArrayOverflowException {
        if (next < items.length){
            items[next++] = x;
        }else {
            throw new ArrayOverflowException("Вышли за пределы размера массива");
        }
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public T current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }
    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence<String> sequence = new Sequence(10);
        for (int i = 0; i < 10; i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
