package chapter14.pets;

import chapter14.factory.Factory;

public class Cat extends Pet{
    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }

    public static class Factory implements chapter14.factory.Factory<Cat> {

        @Override
        public Cat create() {
            return new Cat();
        }
    }
}
