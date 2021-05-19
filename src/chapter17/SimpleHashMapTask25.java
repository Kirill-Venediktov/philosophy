package chapter17;

import util.Countries;

import java.util.*;

public class SimpleHashMapTask25<K,V> extends AbstractMap<K,V> {
    MapEntry<K,V> first = null;
    private Set<Entry<K,V>> entrySet;
    private Set<K> keySet;

    public V put(K key, V value) {
        V oldValue = null;
        MapEntry<K,V> pair = new MapEntry<>(key, value);
        int index = Math.abs(key.hashCode());
        if (first == null)
            first = pair;
        else {
            MapEntry<K, V> currentMapEntry = first;
            while (currentMapEntry.getNext() != null && index > Math.abs(currentMapEntry.getNext().getKey().hashCode()))
                currentMapEntry = currentMapEntry.getNext();
            if (index == Math.abs(currentMapEntry.getKey().hashCode())) {
                oldValue = currentMapEntry.getValue();
                currentMapEntry.setValue(value);
            } else if (currentMapEntry.getNext() != null) {
                MapEntry<K, V> next = currentMapEntry.getNext();
                pair.setNext(next);
                currentMapEntry.setNext(pair);
            } else
                currentMapEntry.setNext(pair);
        }
        return oldValue;
//
//
//            while (index > currentIndex){
//                if (currentMapEntry.getNext() != null){
//                    currentMapEntry = currentMapEntry.getNext();
//                    currentIndex = Math.abs(currentMapEntry.getKey().hashCode());
//                }else {
//                    currentMapEntry.setNext(pair);
//                    return oldValue;
//                }
//            }
//            if (index == currentIndex){
//                oldValue = currentMapEntry.getValue();
//                currentMapEntry.setValue(value);
//            }else {
//                MapEntry<K,V> next = currentMapEntry;
//
//            }
//
//            MapEntry<K,V> next = null;
//            while (index <  Math.abs(next.getKey().hashCode()));
//        }
//
//
//
//        while(index < )
//
//
//
//
//
//        MapEntry<K,V> next = null;
//        int index = Math.abs(key.hashCode()) % SIZE;
//        int first = getFirstNotNullBucketIndex();
//        int last = getLastNotNullBucketIndex();
//        if (buckets[index] == null){
//            buckets[index] = new LinkedList<>();
//        }
//        LinkedList<MapEntry<K,V>> bucket = buckets[index];
//        if (first == -1)
//            bucket.add(pair);
//        else if (index < first){
//            pair.setNext(buckets[first].get(0));
//            bucket.add(pair);
//        } else if (index > last) {
//            buckets[last].get(buckets[last].size() - 1).setNext(pair);
//            bucket.add(pair);
//        }else{
//            boolean found = false;
//            for (MapEntry<K, V> iPair : bucket) {
//                if (iPair.getKey().equals(key)) {
//                    oldValue = iPair.getValue();
//                    iPair.setValue(value);
//                    found = true;
//                    break;
//                }
//            }
//            if (!found){
//                MapEntry<K,V> previous;
//                if (bucket.size() != 0){
//                    previous = bucket.get(bucket.size() - 1);
//                    next = previous.getNext();
//                    pair.setNext(next);
//                    previous.setNext(pair);
//                    bucket.add(pair);
//                }else {
//                    for (int i = index-1; i > first - 1; i--){
//                        if (buckets[i] != null && buckets[i].size() != 0){
//                            previous = buckets[i].get(buckets[i].size() - 1);
//                            next = previous.getNext();
//                            pair.setNext(next);
//                            previous.setNext(pair);
//                            bucket.add(pair);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return oldValue;
    }

    @Override
    public V get(Object key) {
        for (Entry<K,V> entry : entrySet())
            if (entry.getKey().equals(key))
                return entry.getValue();
        return null;
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
        V removedValue = null;
        MapEntry<K,V> current = null;
        MapEntry<K,V> previous = null;
        if (first != null){
            current = first;
            while (current.hasNext()){
                if (current.getKey().equals(key)){
                    removedValue = current.getValue();
                    if (previous != null){
                        if (current.hasNext())
                            previous.setNext(current.getNext());
                        else previous.setNext(null);
                    }else {
                        if (current.hasNext())
                            first = current.getNext();
                        else first = null;
                    }
                    break;
                }
                previous = current;
                current = current.getNext();
            }
        }return removedValue;

    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public int size() {
        int size = 0;
        MapEntry<K,V> current = first;
        if (current != null){
            size = 1;
            while (current.hasNext()){
                size++;
                current = current.getNext();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K,V> entry : entrySet())
            if (entry.getValue().equals(value))
                return true;
            return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Entry<K,V> entry : entrySet())
            if (entry.getKey().equals(key))
                return true;
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
        SimpleHashMapTask25<?, ?> that = (SimpleHashMapTask25<?, ?>) o;
        return Objects.equals(first, that.first) && Objects.equals(entrySet, that.entrySet) && Objects.equals(keySet, that.keySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), first, entrySet, keySet);
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        SimpleHashMapTask25<?, ?> that = (SimpleHashMapTask25<?, ?>) o;
//        return Arrays.equals(buckets, that.buckets);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + Arrays.hashCode(buckets);
//        return result;
//    }



    private class KeySet extends AbstractSet<K> {
        @Override
        public Iterator<K> iterator() {
            return new Iterator<>() {
                private MapEntry<K,V> current = null;
                private MapEntry<K,V> previous = null;


                  @Override
                public boolean hasNext() {
                      if (first == null)
                          return false;
                      if (current == null){
                          current = first;
                      }
                      return current.hasNext();
                }

                @Override
                public void remove() {
                    if (previous != null){
                        if (hasNext())
                            previous.setNext(current.getNext());
                        else previous.setNext(null);
                    }else {
                        if (hasNext())
                            first = current.getNext();
                        else first = null;
                    }
                }

                @Override
                public K next() {
                    if (current == null)
                        current = first;
                    else {
                        previous = current;
                        current = current.getNext();
                    }
                    return current.getKey();
                }
            };
        }

        @Override
        public int size() {
            return SimpleHashMapTask25.this.size();
        }
    }

    private class EntrySet extends AbstractSet<Entry<K,V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<>() {
                private MapEntry<K,V> current = null;
                private MapEntry<K,V> previous = null;

                @Override
                public boolean hasNext() {
                    if (first == null)
                        return false;
                    if (current == null){
                        current = first;
                    }
                    return current.hasNext();
                }

                @Override
                public void remove() {
                    if (previous != null){
                        if (hasNext())
                        previous.setNext(current.getNext());
                        else previous.setNext(null);
                    }else {
                        if (hasNext())
                            first = current.getNext();
                        else first = null;
                    }
                }

                @Override
                public Entry<K, V> next() {
                    if (current == null)
                        current = first;
                    else {
                        previous = current;
                        current = current.getNext();
                    }
                    return current;
                    }
            };
        }

        @Override
        public int size() {
            return SimpleHashMapTask25.this.size();
        }
    }

    public static void main(String[] args) {
        SimpleHashMapTask25<String,String > m = new SimpleHashMapTask25<>();
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
