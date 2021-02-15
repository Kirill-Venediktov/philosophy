package chapter14.pets;

public class Rodent extends Pet{
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
    }

    public static class Factory implements chapter14.factory.Factory<Rodent> {

        @Override
        public Rodent create() {
            return new Rodent();
        }
    }
}
