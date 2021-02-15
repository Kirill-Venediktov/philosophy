package chapter15.coffee;

public class Cappuccino extends Coffee{
    public static class Factory implements chapter14.factory.Factory<Cappuccino>{
        @Override
        public Cappuccino create() {
            return new Cappuccino();
        }
    }
}
