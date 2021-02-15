package chapter14;

import chapter12.Switch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Shape {
   static boolean isMarked;
    void draw() {
        System.out.println(this + ".draw");
    }
    @Override
    abstract public String toString();
}

class Circle extends Shape {
    static boolean isMarked;
    @Override
    public String toString() {
        return "Circle{" +
                "isMarked=" + isMarked +
                '}';
    }

}

class Square extends Shape {
    static boolean isMarked;
    @Override
    public String toString() {
        return "Square{" +
                "isMarked=" + isMarked +                '}';
    }
}

class Triangle extends Shape {
    static boolean isMarked;
    @Override
    public String toString() {
        return "Triangle{" +
                "isMarked=" + isMarked +
                '}';
    }
}

class Rhomboid extends Shape {
    static boolean isMarked;
    @Override
    public String toString() {
        return "Rhomboid{" +
                "isMarked=" + isMarked +
                '}';
    }
}

public class Shapes {

    public static void rotate(Shape shape){
        if (!(shape instanceof Circle)){
            System.out.println(shape + ".rotate");
        }
    }

    public static void mark(int i) {
        switch (i) {
            case 1 :
                Circle.isMarked = true;
                break;
            case 2 :
                Square.isMarked = true;
                break;
            case 3 :
                Triangle.isMarked = true;
                break;
            case 4 :
                Rhomboid.isMarked = true;
                break;
            case 0 :
                Circle.isMarked = false;
                Square.isMarked = false;
                Triangle.isMarked = false;
                Rhomboid.isMarked = false;
                break;
            default:
            case 5 :
                break;
        }
    }

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
        for (Shape shape : shapeList) {
            shape.draw();
        }
        System.out.println("---------------");
        Shape shape = new Rhomboid();
        shape.draw();
        if (shape instanceof Rhomboid){
            Rhomboid rhomboid = (Rhomboid) shape;
            System.out.println(rhomboid.toString());
        }

        System.out.println("-------------");

        rotate(shape);

        for (Shape shape1 : shapeList){
            rotate(shape1);
        }

//        Circle circle = (Circle) shape;

        System.out.println("--------------");

        List<Shape> shapeList1 = Arrays.asList(new Circle(), new Square(), new Circle(), new Rhomboid(), new Triangle());
        for (Shape shape2 : shapeList) {
            shape2.draw();
        }
        Circle circle = new Circle();
        mark(1);

        System.out.println("???");
        for (Shape shape2 : shapeList) {
            shape2.draw();
        }


    }
}
