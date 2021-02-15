package chapter14.pets;

public class EgyptianMau extends Cat{
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
    }

    public static class Factory implements chapter14.factory.Factory<EgyptianMau> {

        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}
