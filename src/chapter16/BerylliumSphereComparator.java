package chapter16;

import java.util.Comparator;

public class BerylliumSphereComparator implements Comparator<BerylliumSphere> {
    @Override
    public int compare(BerylliumSphere b1, BerylliumSphere b2) {
        return (Long.compare(b2.getId(), b1.getId()));
    }
}
