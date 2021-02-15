package chapter14.pets;

public class Mutt extends Dog{
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
    }

    public static class Factory implements chapter14.factory.Factory<Mutt> {

        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}
