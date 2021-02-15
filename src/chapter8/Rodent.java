package chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public interface Rodent {

    public abstract void Scream();
    public abstract void Eat();


}

class Mouse implements Rodent{
    private Bread b = new Bread();
    public Mouse() {
        System.out.println("Mouse");
    }

    @Override
    public void Scream() {
        System.out.println("Mouse scream");
    }

    @Override
    public void Eat() {
        System.out.println("Mouse eats");
    }

    public static void main(String[] args) {
        RandomRodentGenerator generator = new RandomRodentGenerator();
        List<Rodent> rodents = new ArrayList<>();
        for (int i = 0; i< 7; i++){
            rodents.add(generator.next());
        }
        Iterator<Rodent> iterator = rodents.iterator();
        while (iterator.hasNext()){
            Rodent rodent = iterator.next();
            rodent.Scream();
            rodent.Eat();
        }
    }
}

class Hamster implements Rodent {
    private Lettuce l = new Lettuce();
    public Hamster() {
        System.out.println("Hamster");
    }

    @Override
    public void Scream() {
        System.out.println("Hamster scream");
    }

    @Override
    public void Eat() {
        System.out.println("Hamster eats");
    }
}

class RandomRodentGenerator{
    private Random random = new Random();

    public Rodent next(){
        switch (random.nextInt(2)){
            default:
            case 0: return new Mouse();
            case 1: return new Hamster();
        }
    }
}
