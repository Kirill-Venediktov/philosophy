package chapter15.coffee;

import util.TypeCounter;

public class CoffeeCounter {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Coffee.class);
        for (Coffee coffee : new CoffeeGenerator(10)){
            System.out.println(coffee.getClass().getSimpleName());
            typeCounter.count(coffee);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}
