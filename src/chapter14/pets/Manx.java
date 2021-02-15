package chapter14.pets;

public class Manx extends Cat{
    public Manx(String name) {
        super(name);
    }

    public Manx() {
    }

    public static class Factory implements chapter14.factory.Factory<Manx> {

        @Override
        public Manx create() {
            return new Manx();
        }
    }
}
