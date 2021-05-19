package chapter17;

import util.CountingMapData;
import util.Countries;

import java.util.*;

public class SlowMap<K, V> extends AbstractMap<K,V> {
    private Set<K> keySet;
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SlowMap<?, ?> slowMap = (SlowMap<?, ?>) o;
        return Objects.equals(keySet, slowMap.keySet) && Objects.equals(keys, slowMap.keys) && Objects.equals(values, slowMap.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keySet, keys, values);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        }else values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new LinkedHashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry<K,V>(ki.next(),vi.next()));
        return set;
    }

    @Override
    public V remove(Object key) {
        if (keys.contains(key)){
           V removedValue = values.remove(keys.indexOf(key));
            keys.remove(key);
            return removedValue;
        }else return null;
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
        keys.clear();
        values.clear();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

    final class KeySet extends AbstractSet<K> {

            @Override
            public int size() {
                return SlowMap.this.keys.size();
            }

            @Override
            public boolean isEmpty() {
                return SlowMap.this.isEmpty();
            }

            @Override
            public boolean contains(Object o) {
                return SlowMap.this.keys.contains(o);
            }

            @Override
            public Iterator<K> iterator() {
                return SlowMap.this.keys.iterator();
            }

            @Override
            public Object[] toArray() {
                return SlowMap.this.keys.toArray();
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return SlowMap.this.keys.toArray(ts);
            }

            @Override
            public boolean add(K k) {
                if (!keys.contains(k)){
                    keys.add(k);
                    values.add(null);
                    return true;
                }else return false;
            }

            @Override
            public boolean remove(Object o) {
               if (keys.contains(o)){
                   values.remove(keys.indexOf(o));
                   keys.remove(o);
                   return true;
               }else return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return keys.containsAll(collection);
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
                for (K k : keys) {
                    if (!collection.contains(k)){
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
                    if (keys.contains(k)){
                        values.remove(keys.indexOf(k));
                        keys.remove(k);
                        modified = true;
                    }
                }
                    return modified;
            }

            @Override
            public void clear() {
                SlowMap.this.clear();
            }

    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
        System.out.println("-------");
        SlowMap<Integer, String> m2 = new SlowMap<>();
        m2.putAll(new CountingMapData(25));
        System.out.println(m.keySet());
        System.out.println(m2);

        m2.entrySet().clear();
        System.out.println(m2);
    }
}
