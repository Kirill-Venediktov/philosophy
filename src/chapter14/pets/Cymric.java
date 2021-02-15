package chapter14.pets;

public class Cymric extends Manx{
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
    }

    public static class Factory implements chapter14.factory.Factory<Cymric> {

        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}
