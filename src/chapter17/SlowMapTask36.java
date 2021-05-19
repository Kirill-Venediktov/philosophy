package chapter17;


import util.CountingMapData;
import util.Countries;

import java.util.*;

public class SlowMapTask36<K, V> extends AbstractMap<K,V> {
    private Set<K> keySet;
    private Set<Map.Entry<K,V>> entrySet;
    private List<MapEntry<K,V>> entries = new ArrayList<>();
    private MapEntryKeyComp<K,V> comp = new MapEntryKeyComp<K, V>();

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry entry : entries){
            if (entry.getValue().equals(value))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Map.Entry entry : entries){
            if (entry.getKey().equals(key))
                return true;
        }
        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Iterator<? extends Entry<? extends K, ? extends V>> it = m.entrySet().iterator();
        while (it.hasNext()){
            Entry<? extends K, ? extends V> entry = it.next();
            put(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Map.Entry<K,V> entry : entries)
            values.add(entry.getValue());
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SlowMapTask36<?, ?> that = (SlowMapTask36<?, ?>) o;
        return Objects.equals(keySet, that.keySet) && Objects.equals(entrySet, that.entrySet) && Objects.equals(entries, that.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keySet, entrySet, entries);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public V put(K key, V value) {
        V oldValue = null;
        boolean isFound = false;
        for (Entry<K,V> entry : entries){
            if (entry.getKey().equals(key)){
                oldValue = entry.getValue();
                entry.setValue(value);
                isFound = true;
            }
        }
        if (!isFound)
            entries.add(new MapEntry<>(key,value));
        Collections.sort(entries, comp);
        return oldValue;
    }

//    private void sort() {
//        Map.Entry<K, V> previous = null;
//        Map.Entry<K, V> current = null;
//        for (int i = 0; i < entries.size(); i++) {
//            previous = current;
//            current = entries.get(i);
//            if (previous != null) {
//                if ((Integer.compare(current.hashCode(), previous.hashCode())) < 0) {
//                    entries.set(i - 1, current);
//                    entries.set(i, previous);
//                }
//            }
//        }
//    }

    @Override
    public V get(Object key) {
        MapEntry<K,V> forSearch = new MapEntry<K,V>((K) key,null);
        Collections.binarySearch(entries,forSearch,comp);

        for (Map.Entry<K,V> entry : entries)
            if (entry.getKey().equals(key))
                return entry.getValue();
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> es = this.entrySet;
        if (es == null) {
            es = new SlowMapTask36<K,V>.EntrySet();
            this.entrySet = es;
        }
        return es;
    }

    @Override
    public V remove(Object key) {
        V removedValue = null;
        for (Map.Entry<K,V> entry : entries){
            if (entry.getKey().equals(key)){
              removedValue = entry.getValue();
              entries.remove(entry);
            }
        }
        return removedValue;
    }

    @Override
    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks == null) {
            ks = new KeySet();
            this.keySet = ks;
        }
        return ks;
    }


    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public int size() {
        return entries.size();
    }

    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        @Override
        public void clear() {
            SlowMapTask36.this.clear();
        }
        //        @Override
//        public Iterator<Map.Entry<K, V>> iterator() {
//            return entries.iterator();
//        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private  Iterator<MapEntry<K,V>> entriesIter = entries.iterator();
                @Override
                public boolean hasNext() {
                    return entriesIter.hasNext();
                }

                @Override
                public Entry<K, V> next() {
                    return entriesIter.next();
                }
            };
        }

        @Override
        public int size() {
            return entries.size();
        }
    }

    final class KeySet extends AbstractSet<K> {

            @Override
            public int size() {
                return SlowMapTask36.this.size();
            }

            @Override
            public boolean isEmpty() {
                return SlowMapTask36.this.isEmpty();
            }

            @Override
            public boolean contains(Object o) {
                return SlowMapTask36.this.containsKey(o);
            }

            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>() {
                    private  Iterator<MapEntry<K,V>> entriesIter = entries.iterator();
                    @Override
                    public boolean hasNext() {
                        return entriesIter.hasNext();
                    }

                    @Override
                    public K next() {
                        return entriesIter.next().getKey();
                    }
                };
            }

            @Override
            public Object[] toArray() {
                Object[] keys = new Object[SlowMapTask36.this.size()];
                for (int i = 0; i < SlowMapTask36.this.entries.size(); i++)
                    keys[i] = SlowMapTask36.this.entries.get(i).getKey();
                return keys;
            }

            @Override
            public boolean add(K k) {
                boolean isAdded = false;
                if (!SlowMapTask36.this.containsKey(k)){
                    SlowMapTask36.this.put(k, null);
                    isAdded = true;
                }
                return isAdded;
            }

            @Override
            public boolean remove(Object o) {
                boolean isRemoved = false;
                if (SlowMapTask36.this.containsKey(o)){
                    SlowMapTask36.this.remove(o);
                    isRemoved = true;
                }
                return isRemoved;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                for (Object key : collection)
                    if (!SlowMapTask36.this.containsKey(key))
                        return false;
                return true;
            }

            @Override
            public boolean addAll(Collection<? extends K> collection) {
                boolean modified = false;
                for (K k : collection) {
                    if (add(k)){
                        modified = true;
                    }
                }
                return modified;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                boolean modified = false;
                for (K k : this) {
                    if (!collection.contains(k)) {
                        remove(k);
                        modified = true;
                    }
                }
                return modified;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                boolean modified = false;
                Set<?> cs =new HashSet<>(collection);

                for (Object k : cs) {
                    if (SlowMapTask36.this.containsKey(k)){
                        SlowMapTask36.this.remove(k);
                        modified = true;
                    }
                }
                    return modified;
            }

            @Override
            public void clear() {
                SlowMapTask36.this.clear();
            }

    }

    public static void main(String[] args) {
        SlowMapTask36<String, String> m = new SlowMapTask36<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
        System.out.println("-------");
        SlowMapTask36<Integer, String> m2 = new SlowMapTask36<>();
        m2.putAll(new CountingMapData(25));
        System.out.println(m.keySet());
        System.out.println(m2);

        m2.entrySet().clear();
        System.out.println(m2);
    }
}

class MapEntryKeyComp<K,V> implements Comparator<MapEntry<K,V>> {
    public int compare(MapEntry<K,V> me1, MapEntry<K,V> me2) {
        return me1.getKey().hashCode() - me2.getKey().hashCode();
    }
}
