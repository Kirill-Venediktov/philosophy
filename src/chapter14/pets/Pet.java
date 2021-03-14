package chapter14.pets;

import chapter14.factory.Factory;
import chapter17.Individual;

import java.util.ArrayList;
import java.util.List;

public class Pet extends Individual {
    public Pet(String name) {
        super(name);
    }
    public Pet() {
    }
    static {

    }

    public void speak() {
        System.out.println(this + "speaks");
    }

    public static class Factory implements chapter14.factory.Factory<Pet> {

        @Override
        public Pet create() {
            return new Pet();
        }
    }

}
