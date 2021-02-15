package chapter14;

public class Task10 {
    public static void isPrimitive(Object o) {
          if (o.getClass().isPrimitive()){
            System.out.println("Примитивный тип");
        } else {
            System.out.println("Настоящий объект");
        }
    }

    public static void main(String[] args) {
        char c = 'g';
        Character q = 't';
        isPrimitive(c);
        isPrimitive(q);
    }
}
