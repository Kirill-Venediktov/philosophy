package chapter16;

public class BerylliumSphere implements Comparable<BerylliumSphere> {
    private static long counter;
    private final long id = counter++;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(BerylliumSphere berylliumSphere) {
        return (Long.compare(getId(), berylliumSphere.getId()));
    }
}
