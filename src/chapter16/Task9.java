package chapter16;

import java.util.ArrayList;

class Banana {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }
}

class Peel<T> {
    private T t;

    public Peel(T t) {
        this.t = t;
    }
}

public class Task9 {
    public static void main(String[] args) {
//        Peel<Banana>[] peels = new Peel<Banana>[4];
        ArrayList<Peel<Banana>> peels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            peels.add(new Peel<>(new Banana()));
        }
    }
}
