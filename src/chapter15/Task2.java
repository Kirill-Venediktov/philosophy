package chapter15;

import chapter14.Task25;
import chapter14.pets.Pet;
import chapter14.pets.Task15_PetCreator2;

public class Task2 <T> {
   private Pet pet1;
   private Pet pet2;
   private Pet pet3;

    public Task2(Pet pet1, Pet pet2, Pet pet3) {
        this.pet1 = pet1;
        this.pet2 = pet2;
        this.pet3 = pet3;
    }

    public Pet getPet1() {
        return pet1;
    }

    public void setPet1(Pet pet1) {
        this.pet1 = pet1;
    }

    public Pet getPet2() {
        return pet2;
    }

    public void setPet2(Pet pet2) {
        this.pet2 = pet2;
    }

    public Pet getPet3() {
        return pet3;
    }

    public void setPet3(Pet pet3) {
        this.pet3 = pet3;
    }

    public static void main(String[] args) {
        Task15_PetCreator2 creator = new Task15_PetCreator2();
        Task2<Pet> petTask2 = new Task2<>(creator.randomPet(), creator.randomPet(), creator.randomPet());
        System.out.println(petTask2.getPet1());
        System.out.println(petTask2.getPet2());
        System.out.println(petTask2.getPet3());

    }
}
