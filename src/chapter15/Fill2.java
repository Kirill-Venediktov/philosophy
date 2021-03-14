package chapter15;

import chapter14.pets.Dog;
import chapter14.pets.Hamster;
import chapter14.pets.Pet;
import chapter14.pets.Rat;
import util.Generator;
import util.SimpleQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T> {
    void add(T t);
}

public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            }catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i< size; i++) {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> colletionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Pet> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(carrier), Pet.class, 3);

        Fill2.fill(Adapter.colletionAdapter(carrier), Dog::new, 2);

        for (Pet pet : carrier) {
            System.out.println(pet);
        }
        System.out.println("----------------");
        AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<>();
        Fill2.fill(petQueue, Hamster.class, 4);
        Fill2.fill(petQueue, Rat.class, 1);
        for (Pet pet : petQueue) {
            System.out.println(pet);
        }
    }

}
