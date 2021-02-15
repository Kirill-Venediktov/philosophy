package chapter15.coffee;

public class Breve extends Coffee{
    public static class Factory implements chapter14.factory.Factory<Breve>{
        @Override
        public Breve create() {
            return new Breve();
        }
    }
}
