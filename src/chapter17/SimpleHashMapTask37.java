package chapter17;

import util.Countries;

import java.util.*;

public class SimpleHashMapTask37<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;
    private Set<Entry<K,V>> entrySet;
    private Set<K> keySet;
    @SuppressWarnings("unchecked")
    ArrayList<MapEntry<K,V>>[] buckets = new ArrayList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new ArrayList<>();
        ArrayList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        int count = 0;
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            count++;
            if (iPair.getKey().equals(key)){
                System.out.println("Коллизия: значение " + iPair + " заменяется " + pair + " . Колличество проб: " + count);
                count = 0;
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K,V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

//    public LinkedList<MapEntry<K,V>> firstBucket() {
//        LinkedList<MapEntry<K,V>> firstBucket = null;
//        for (LinkedList<MapEntry<K,V>> bucket : buckets){
//            if (bucket != null){
//                firstBucket = bucket;
//                break;
//            }
//        }
//        return firstBucket;
//    }

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

//    public LinkedList<MapEntry<K,V>> lastBucket() {
//        LinkedList<MapEntry<K,V>> lastBucket = null;
//        for (int i = 0; i < SIZE; i++){
//            if (buckets[i] != null){
//                lastBucket = buckets[i];
//            }
//        }
//        return lastBucket;
//    }

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
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> es = this.entrySet;
        if (es == null) {
            es = new EntrySet();
            this.entrySet = es;
        }
        return es;
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        V removedValue = null;
        if (buckets[index] == null) return null;
        for (MapEntry<K,V> iPair : buckets[index]){
            if (iPair.getKey().equals(key)){
                removedValue = iPair.getValue();
                buckets[index].remove(iPair);
                break;
            }
        }
        return removedValue;
    }

    @Override
    public void clear() {
        for (ArrayList<MapEntry<K,V>> bucket : buckets)
            if (bucket != null)
                bucket.clear();
    }

    @Override
    public int size() {
        int size = 0;
        for (ArrayList<MapEntry<K,V>> bucket : buckets)
            if (bucket != null)
                size += bucket.size();
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (ArrayList<MapEntry<K,V>> bucket : buckets){
            if (bucket != null && bucket.size() != 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean containsValue(Object value) {
        for (ArrayList<MapEntry<K,V>> bucket : buckets){
            for (MapEntry<K,V> entry : bucket)
                if (entry.getValue().equals(value))
                    return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for (ArrayList<MapEntry<K,V>> bucket : buckets){
            for (MapEntry<K,V> entry : bucket)
                if (entry.getKey().equals(key))
                    return true;
        }
        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet())
            put(entry.getKey(),entry.getValue());
    }

    @Override
    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks == null) { ks = new KeySet();
            this.keySet = ks;
        }
        return ks;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Entry<K,V> iPair : entrySet()){
            values.add(iPair.getValue());
        }
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleHashMapTask37<?, ?> that = (SimpleHashMapTask37<?, ?>) o;
        return Arrays.equals(buckets, that.buckets);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(buckets);
        return result;
    }



    private class KeySet extends AbstractSet<K> {
        @Override
        public Iterator<K> iterator() {
            return new Iterator<>() {
                private int bucketsIndex = getFirstNotNullBucketIndex() -1;
                private int listIndex = 0;

                  @Override
                public boolean hasNext() {
                    return bucketsIndex < getLastNotNullBucketIndex() && getLastNotNullBucketIndex() != -1;
                }

                @Override
                public void remove() {
                    ArrayList<MapEntry<K, V>> list = null;
                    for (int i = bucketsIndex; i < getLastNotNullBucketIndex() + 1; i++){
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
                        list.remove(listIndex);
                        bucketsIndex--;
                    }
                }

                @Override
                public K next() {
                    bucketsIndex++;
                    ArrayList<MapEntry<K, V>> list = null;
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
                        MapEntry<K, V> entry = list.get(listIndex);
                        if (listIndex != list.size() - 1){
                            listIndex++;
                            bucketsIndex--;
                        }else listIndex = 0;

                        return entry.getKey();
                    }else return null;
                }
            };
        }

        @Override
        public int size() {
            return SimpleHashMapTask37.this.size();        }
    }

    private class EntrySet extends AbstractSet<Entry<K,V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<>() {
                private int bucketsIndex = getFirstNotNullBucketIndex() -1;
                private int listIndex = 0;

                @Override
                public boolean hasNext() {
                    return bucketsIndex < getLastNotNullBucketIndex() && getLastNotNullBucketIndex() != -1;
                }

                @Override
                public void remove() {
                    ArrayList<MapEntry<K, V>> list = null;
                    for (int i = bucketsIndex; i < getLastNotNullBucketIndex() + 1; i++){
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
                        list.remove(listIndex);
                        bucketsIndex--;
                    }
                }

                @Override
                public Entry<K, V> next() {
                    bucketsIndex++;
                    ArrayList<MapEntry<K, V>> list = null;
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
                        MapEntry<K, V> entry = list.get(listIndex);
                        if (listIndex != list.size() - 1){
                            listIndex++;
                            bucketsIndex--;
                        }else listIndex = 0;

                        return entry;
                    }else return null;
                    }
            };
        }

        @Override
        public int size() {
            return SimpleHashMapTask37.this.size();
        }
    }

    public static void main(String[] args) {
        SimpleHashMapTask37<String,String > m = new SimpleHashMapTask37<>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.size());
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
        System.out.println("---------");
        System.out.println(m.values());
        System.out.println(m.keySet());
        m.clear();
        System.out.println(m.size());
        System.out.println(m);
        m.putAll(Countries.capitals(13));
        System.out.println(m.size());
        System.out.println(m.entrySet());
        System.out.println(m.values());

    }
}
