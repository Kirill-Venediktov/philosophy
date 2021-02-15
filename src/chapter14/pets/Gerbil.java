package chapter14.pets;

public class Gerbil extends Rodent{
    public Gerbil(String name) {
        super(name);
    }

    public Gerbil() {
    }

    public static class Factory implements chapter14.factory.Factory<Gerbil> {

        @Override
        public Gerbil create() {
            return new Gerbil();
        }
    }
}
