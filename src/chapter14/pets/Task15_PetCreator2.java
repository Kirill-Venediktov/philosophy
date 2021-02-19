package chapter14.pets;

import chapter14.factory.Factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task15_PetCreator2 {
    private Random rand = new Random();
    static List<Factory<? extends Pet>> petsFactories = new ArrayList<>();
    static {
        petsFactories.add(new Cat.Factory());
        petsFactories.add(new Cymric.Factory());
        petsFactories.add(new Dog.Factory());
        petsFactories.add(new EgyptianMau.Factory());
        petsFactories.add(new Gerbil.Factory());
        petsFactories.add(new Hamster.Factory());
        petsFactories.add(new Manx.Factory());
        petsFactories.add(new Mouse.Factory());
        petsFactories.add(new Mutt.Factory());
        petsFactories.add(new Pet.Factory());
        petsFactories.add(new Pug.Factory());
        petsFactories.add(new Rat.Factory());
        petsFactories.add(new Rodent.Factory());
    }

    public Pet randomPet() {
        int n = rand.nextInt(petsFactories.size());
        return petsFactories.get(n).create();
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++){
            result[i] = randomPet();
        }
        return result;
    }
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result,createArray(size));
        return result;
    }
}
