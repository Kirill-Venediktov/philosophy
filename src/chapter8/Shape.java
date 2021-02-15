package chapter8;

import chapter7.A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Shape {
    public void draw(){}
    public void erase(){}
    public void sayHello(){
        System.out.println("Hello");
    }
}

class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, im circle");
    }
}

class Square extends Shape{
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, im square");
    }
}

class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, im triangle");
    }
}

class Rhombus extends Shape{
    @Override
    public void draw() {
        System.out.println("Rhombus.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Rhombus.erase()");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, im rhombus");
    }
}

class RandomShapeGenerator implements Iterable<Shape> {
    private Random random = new Random();
    private int countOfIterations =0;
    private int index = 0;

    public RandomShapeGenerator() {
    }
    public RandomShapeGenerator(int countOfIterations) {
        this.countOfIterations = countOfIterations;

    }

    public Shape nextShape(){
        switch (random.nextInt(4)){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
            case 3: return new Rhombus();
        }
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            @Override
            public boolean hasNext() {
                return index < countOfIterations;
            }

            @Override
            public Shape next() {
                index++;
                return nextShape();
            }
        };
    }
}



class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    private static int counter = 10;
    private static RandomShapeGenerator generator = new RandomShapeGenerator(counter);

    public static void main(String[] args) {
//        Shape[] s = new Shape[9];
//        for (int i = 0; i < s.length; i++){
//            s[i] = gen.next();
//        }
//        for(Shape shape : s){
//            shape.draw();
//            shape.sayHello();


//        while (generator.iterator().hasNext()){
//            generator.iterator().next().sayHello();
        ArrayList<Shape> shapes = new ArrayList<>();

        for (Shape shape : generator){
            shapes.add(shape);
            shape.sayHello();

        }
    }
}