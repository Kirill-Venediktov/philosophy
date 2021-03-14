package chapter15;

import java.util.ArrayList;

class FixedSizeStack<T> {
    private int index = 0;
    private ArrayList<Object> storage;

    public FixedSizeStack() {
        storage = new ArrayList<>();
    }

    public int getLength() {
        return storage.size();
    }

    public int getIndex() {
        return index;
    }

    public void push(T item) {
        index++;
        storage.add(item);
    }
    @SuppressWarnings("unckeked")
    public T pop() {
        return (T) storage.get(--index);
    }
}

public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>();
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        strings.push("gggg");
        for (int i = 0; i < strings.getLength(); i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
