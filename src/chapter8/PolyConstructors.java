package chapter8;

class Glyph {
    void draw() {
        System.out.println("Glyph.draw");
    }
    Glyph() {
        System.out.println("Glyph перед вызовом draw()");
        draw();
        System.out.println("Glyph после вызова draw()");
    }
}

class RectangularGlyph extends Glyph{
    private int a_length = 1;
    private int b_length = 4;
    private int c_length = 3;

    public RectangularGlyph(int a_length, int b_length, int c_length) {
        this.a_length = a_length;
        this.b_length = b_length;
        this.c_length = c_length;

        System.out.println("Конструктор RectangularGlyph");
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw");
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RectangularGlyph(5,4,3);
    };
}
