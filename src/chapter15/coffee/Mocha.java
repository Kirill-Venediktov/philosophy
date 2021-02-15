package chapter15.coffee;

public class Mocha extends Coffee{
    public static class Factory implements chapter14.factory.Factory<Mocha>{
        @Override
        public Mocha create() {
            return new Mocha();
        }
    }
}
