package chapter8;

import java.security.PublicKey;

interface Fastfood{
    void beFat();
    void beTasty();
}

class Meal{
    public Meal() {
        System.out.println("Meal");
    }
}

class Bread{
    public Bread() {
        System.out.println("Bread");
    }
}

class Cheese {
    private static int count = 0;

    public static void addref(){
        count++;
        System.out.println("Вызов № " + count);
    }

    public Cheese(){
        System.out.println("Cheese");
    }
}

class Lettuce {
    public Lettuce() {
        System.out.println("Lettuce");
    }
}

class Pickle {
    public Pickle() {
        System.out.println("Pickle");
    }
}

class Lunch extends Meal {
    public Lunch() {
        System.out.println("Lunch");
    }
}

class PortableLunch extends Lunch {
    public PortableLunch() {
        System.out.println("PortableLunch");
    }
}

public class Sandwich implements Fastfood {
    private Bread  b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
    private  Pickle p = new Pickle();
    public Sandwich() {
        System.out.println("Sandwich");
    }

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();
        sandwich.beFat();
        sandwich.beTasty();
    }

    @Override
    public void beFat() {
        System.out.println("Im so fat");
    }

    @Override
    public void beTasty() {
        System.out.println("Im very taste");
    }
}
