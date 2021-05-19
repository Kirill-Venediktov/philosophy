package chapter17;

import java.util.*;

public class SimpleHashSet<V> extends AbstractSet<V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<V>[] buckets = new LinkedList[SIZE];

    private int getFirstNotNullBucketIndex() {
        int indexOfFirst = -1;
        for (int i = 0; i < SIZE; i++){
            if (buckets[i] != null && buckets[i].size() != 0){
                indexOfFirst = i;
                break;
            }
        }
        return indexOfFirst;
    }

    private int getLastNotNullBucketIndex() {
        int indexOfLast = -1;
        for (int i = 0; i < SIZE; i++){
            if (buckets[i] != null && buckets[i].size() != 0){
                indexOfLast = i;
            }
        }
        return indexOfLast;
    }


    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private int bucketsIndex = getFirstNotNullBucketIndex() -1;
            private int listIndex = 0;

            @Override
            public boolean hasNext() {
                return bucketsIndex < getLastNotNullBucketIndex() && getLastNotNullBucketIndex() != -1;
            }

            @Override
            public V next() {
                bucketsIndex++;
                LinkedList<V> list = null;
                for (int i = bucketsIndex; i < getLastNotNullBucketIndex() + 1; i++) {
                    list = buckets[i];
                    if (list == null)
                        continue;
                    if (list.size() !=0 ){
                        bucketsIndex = i;
                        break;
                    }
                }
                if (bucketsIndex > getLastNotNullBucketIndex())
                    throw new NoSuchElementException();
                if (list != null){
                    V value = list.get(listIndex);
                    if (listIndex != list.size() - 1){
                        listIndex++;
                        bucketsIndex--;
                    }else listIndex = 0;

                    return value;
                }else return null;
            }

            @Override
            public void remove() {
                LinkedList<V> list = null;
                for (int i = bucketsIndex; i<getLastNotNullBucketIndex() + 1; i++){
                    list = buckets[i];
                    if (list == null)
                        continue;
                    if (list.size() != 0){
                        bucketsIndex = i;
                        break;
                    }
                }
                if (bucketsIndex > getLastNotNullBucketIndex())
                    throw new NoSuchElementException();
                if (list != null){
                    list.remove(listIndex);
                    bucketsIndex--;
                }
            }
        };
    }

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<V> bucket : buckets)
            if (bucket != null)
                size += bucket.size();
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (LinkedList<V> bucket : buckets){
            if (bucket != null && bucket.size() != 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (LinkedList<V> bucket : buckets)
            if (bucket != null && bucket.size() != 0)
                for (V val : bucket)
                    if (val.equals(o))
                        return true;
        return false;
    }

    @Override
    public boolean add(V v) {
        if (!contains(v)){
            int index = Math.abs(v.hashCode()) % SIZE;
            if (buckets[index] == null)
                buckets[index] = new LinkedList<>();
            buckets[index].add(v);
            return true;
        }else return false;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)){
            int index = Math.abs(o.hashCode()) % SIZE;
            buckets[index].remove(o);
            return true;
        }else return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        for (V val : c){
            add(val);
        }
        return super.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<V> it = this.iterator();
        while (it.hasNext()){
            V value = it.next();
            if (!c.contains(value)){
                modified = true;
                it.remove();
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (LinkedList<V> bucket : buckets)
            if (bucket != null)
                bucket.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleHashSet<?> that = (SimpleHashSet<?>) o;
        return Arrays.equals(buckets, that.buckets);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(buckets);
        return result;
    }

    public static void main(String[] args) {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++){
            set.add(random.nextInt(10));
        }

        System.out.println(set);
        System.out.println(set.remove(3));
        System.out.println(set);
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(4,5,6));
        System.out.println("containsAll: " + set.containsAll(integers));
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(5);
        System.out.println("Retainall: " + set.retainAll(ints));
        System.out.println(set);
        set.clear();
        System.out.println(set);

    }
}
