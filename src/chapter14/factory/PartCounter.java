package chapter14.factory;

import util.TypeCounter;

import java.util.ArrayList;
import java.util.List;

public class PartCounter {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        List<Part> parts = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            parts.add(Part.createRandom());
        }
        for (Part part : parts){
            System.out.println(part.getClass().getSimpleName() + " ");
            counter.count(part);
        }
        System.out.println();
        System.out.println(counter);
    }
}
