package chapter17;

import java.util.*;

public class SlowSet<V> extends AbstractSet<V> {
    private List<V> values = new ArrayList<>();

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Set<?> sc = new HashSet<>(c);
        for (Object v : sc) {
            if (remove(v)){
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return values.contains(o);
    }

    @Override
    public Object[] toArray() {
        return values.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return values.toArray(a);
    }

    @Override
    public boolean add(V v) {
        boolean modified = false;
        if (!values.contains(v)){
            values.add(v);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean remove(Object o) {
        boolean modified = false;
        if (values.contains(o)){
            values.remove(o);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return values.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        Set<? extends V> sc = new HashSet<>(c);
        boolean modified = false;
        for (V v : sc) {
            if (add(v)){
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return values.retainAll(c);
    }

    @Override
    public void clear() {
        values.clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Iterator<V> iterator() {
        return values.iterator();
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SlowSet<?> slowSet = (SlowSet<?>) o;
        return Objects.equals(values, slowSet.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), values);
    }

    public static void main(String[] args) {
        Random r = new Random();
        SlowSet<Integer> set = new SlowSet<>();
        for (int i = 0; i < 15; i++) {
            set.add(r.nextInt(10));
        }
        System.out.println(set);
        set.removeAll(set);
        System.out.println(set);
    }
}
