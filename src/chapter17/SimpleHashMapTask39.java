package chapter17;

import util.Countries;

import java.util.*;

public class SimpleHashMapTask39<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;
    private Set<Entry<K,V>> entrySet;
    private Set<K> keySet;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % buckets.length;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
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
        if (checkLoadFactor() > 0.75f)
            rehash();
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % buckets.length;
        if (buckets[index] == null) return null;
        for (MapEntry<K,V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public float checkLoadFactor(){
        return (float) (size()/buckets.length);
    }

    private void rehash() {
        int newSize = buckets.length * 2;
        for (int i = 2; i < newSize; i++){
            if (newSize % i == 0){
                newSize++;
                i = 1;
            }
        }
        LinkedList<MapEntry<K,V>>[] buckets2 = new LinkedList[newSize];
        for (Map.Entry<K,V> entry : entrySet){
            int index = Math.abs(entry.getKey().hashCode()) % buckets2.length;
//            if (index == buckets2.length)
//                index--;
            if (buckets2[index] == null)
                buckets2[index] = new LinkedList<>();
            LinkedList<MapEntry<K,V>> bucket = buckets2[index];
            boolean found = false;
            ListIterator<MapEntry<K,V>> it = bucket.listIterator();
            while (it.hasNext()){
                MapEntry<K,V> iPair = it.next();
                if (iPair.getKey().equals(entry.getKey())){
                    it.set((MapEntry<K, V>) entry);
                    found = true;
                    break;
                }
            }
            if (!found)
                buckets2[index].add((MapEntry<K, V>) entry);
        }
//
//
//        for (int i = getFirstNotNullBucketIndex(); i < getLastNotNullBucketIndex(); i++) {
//            if (buckets[i] != null && buckets[i].size() != 0){
//                for (int j = 0; j < buckets[i].size(); j++){
//                    int index = Math.abs(buckets[i].get(j).getKey().hashCode()) % buckets2.length;
//                    if (buckets2[index] == null)
//                        buckets2[index] = new LinkedList<>();
//                    LinkedList<MapEntry<K,V>> bucket = buckets2[index];
//                    boolean found = false;
//                    ListIterator<MapEntry<K,V>> it = bucket.listIterator();
//                    while (it.hasNext()){
//                        MapEntry<K,V> iPair = it.next();
//                        if (iPair.getKey().equals(buckets[i].get(j).getKey())){
//                            it.set(buckets[i].get(j));
//                            found = true;
//                            break;
//                        }
//                    }
//                    if (!found)
//                        buckets[index].add(buckets[i].get(j));
//                }
//                for (MapEntry<K,V> entry: buckets[i]){
//
//                }


        buckets = buckets2;
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
        for (int i = 0; i < buckets.length; i++){
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
        for (int i = 0; i < buckets.length; i++){
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
        int index = Math.abs(key.hashCode()) % buckets.length;
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
        for (LinkedList<MapEntry<K,V>> bucket : buckets)
            if (bucket != null)
                bucket.clear();
    }

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<MapEntry<K,V>> bucket : buckets)
            if (bucket != null)
                size += bucket.size();
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            if (bucket != null && bucket.size() != 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            for (MapEntry<K,V> entry : bucket)
                if (entry.getValue().equals(value))
                    return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
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
        if (checkLoadFactor() > 0.75f)
            rehash();
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
        SimpleHashMapTask39<?, ?> that = (SimpleHashMapTask39<?, ?>) o;
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
                    LinkedList<MapEntry<K, V>> list = null;
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
                    LinkedList<MapEntry<K, V>> list = null;
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
            return SimpleHashMapTask39.this.size();        }
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
                    LinkedList<MapEntry<K, V>> list = null;
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
                    LinkedList<MapEntry<K, V>> list = null;
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
            return SimpleHashMapTask39.this.size();
        }
    }

    public static void main(String[] args) {
        SimpleHashMapTask39<String,String> m = new SimpleHashMapTask39<>();
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
