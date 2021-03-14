package chapter15;

import util.Generator;

import java.util.ArrayList;
import java.util.Random;

class Container {
    private final int id;
    private String description;
    private double price;

    public Container(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ": " + description +", price: $" + price;
    }
    public static Generator<Container> generator = new Generator<Container>() {
        Random random = new Random();
        @Override
        public Container next() {
            return new Container(random.nextInt(1000), "Test",
                    Math.round(random.nextDouble() * 100000.0));
        }
    };
}

class ContainersStack extends ArrayList<Container> {
    public ContainersStack(int nContainers) {
        Generators.fill(this, Container.generator, nContainers);
    }
}

class Aisle extends ArrayList<ContainersStack> {
    public Aisle(int nContainersStack, int nContainers) {
        for (int i = 0; i < nContainersStack; i++) {
            add(new ContainersStack(nContainers));
        }
    }
}

public class ContainerShip extends ArrayList<Aisle> {
    public ContainerShip(int nAisles, int nContainersStack, int nContainer) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nContainersStack, nContainer));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new  StringBuilder();
        for (Aisle a : this){
            for (ContainersStack stack : a){
                for (Container container : stack){
                    result.append(container);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ContainerShip(40, 50, 20));
    }
}
