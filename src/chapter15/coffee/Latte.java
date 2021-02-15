package chapter15.coffee;

public class Latte extends Coffee{
    public static class Factory implements chapter14.factory.Factory<Latte>{
        @Override
        public Latte create() {
            return new Latte();
        }
    }
}
