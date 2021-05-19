package chapter14.factory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task14_RegisteredFactories2 {
    public static final List<Class<? extends Part>> parts =
            Collections.unmodifiableList(Arrays.asList(AirFilter.class, CabinFilter.class, FuelFilter.class,
                    OilFilter.class, FanBelt.class, GeneratorBelt.class, PowerSteeringBelt.class));

    private static Random random = new Random();

    public static Part getRandomPart(){
        try {
            return parts.get(random.nextInt(parts.size())).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRandomPart());
        }
    }
}
