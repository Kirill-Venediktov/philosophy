package chapter14.pets;

public class Rat extends Rodent{
    public Rat(String name) {
        super(name);
    }

    public Rat() {
    }

    public static class Factory implements chapter14.factory.Factory<Rat> {

        @Override
        public Rat create() {
            return new Rat();
        }
    }
}
