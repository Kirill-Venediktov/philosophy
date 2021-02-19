package chapter15;

import chapter14.pets.Pet;
import chapter14.pets.PetCreator;
import chapter14.pets.Task15_PetCreator2;

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Pet> petHolder3 = new Holder3<>(new Task15_PetCreator2().randomPet());
        Pet pet = petHolder3.getA();
        System.out.println(pet);
    }
}
