package chapter15;

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long Id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject" + id;
    }
}
