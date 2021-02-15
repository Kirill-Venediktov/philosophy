package chapter14.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    private static Random random = new Random(47);
    public static Part createRandom() {
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}


class NullPart extends Part implements Null {
    public NullPart() {
        super();
    }
    public static final Part NULL = new NullPart();
    public static class Factory implements chapter14.factory.Factory<NullPart> {
        public NullPart create() { return (NullPart)NULL; }
    }
    public String toString() { return "NULL"; }

}

class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements chapter14.factory.Factory<FuelFilter>{
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements chapter14.factory.Factory<AirFilter>{
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinFilter extends Filter {
    public static class Factory implements chapter14.factory.Factory<CabinFilter>{
        @Override
        public CabinFilter create() {
            return new CabinFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements chapter14.factory.Factory<OilFilter>{
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Bellt extends Part {}

class FanBelt extends Bellt {
    public static class Factory implements chapter14.factory.Factory<FanBelt> {

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Bellt {
    public static class Factory implements chapter14.factory.Factory<GeneratorBelt> {

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Bellt {
    public static class Factory implements chapter14.factory.Factory<PowerSteeringBelt> {

        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}



public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
