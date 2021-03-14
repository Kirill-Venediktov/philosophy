package chapter15;

import util.Generator;

import java.util.*;

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;
    private LittleFish(){

    }
    @Override
    public String toString() {
        return "LittleFish{" +
                "id=" + id +
                '}';
    }

    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}

class BigFish {
    private static long counter = 1;
    private final long id = counter++;
    private BigFish(){

    }

    @Override
    public String toString() {
        return "BigFish{" +
                "id=" + id +
                '}';
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

public class Ocean {
    public static void eat(BigFish bigFish, LittleFish littleFish) {
        System.out.println(bigFish + " eats " + littleFish);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Queue<LittleFish> littleFishQueue = new LinkedList<>();
        Generators.fill(littleFishQueue, LittleFish.generator(), 15);
        List<BigFish> bigFishList = new ArrayList<>();
        Generators.fill(bigFishList, BigFish.generator(), 4);
        for (LittleFish littleFish : littleFishQueue) {
            eat(bigFishList.get(random.nextInt(bigFishList.size())), littleFish);
        }
    }
}
