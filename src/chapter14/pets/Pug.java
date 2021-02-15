package chapter14.pets;

public class Pug extends Dog{
    public Pug(String name) {
        super(name);
    }

    public Pug() {
    }
    public static class Factory implements chapter14.factory.Factory<Pug> {

        @Override
        public Pug create() {
            return new Pug();
        }
    }
}
