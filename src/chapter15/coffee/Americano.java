package chapter15.coffee;

import chapter14.factory.Factory;

public class Americano extends Coffee{
    public static class Factory implements chapter14.factory.Factory<Americano>{
        @Override
        public Americano create() {
            return new Americano();
        }
    }
}
