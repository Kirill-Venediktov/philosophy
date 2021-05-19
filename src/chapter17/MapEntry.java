package chapter17;

import java.util.Map;
import java.util.Objects;

public class MapEntry <K,V> implements Map.Entry<K,V>, Comparable<MapEntry<K,V>> {
    private K key;
    private V value;
    private MapEntry<K,V> next = null;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    public MapEntry<K, V> getNext() {
        return next;
    }

    public void setNext(MapEntry<K, V> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return getNext() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
        return Objects.equals(key, mapEntry.key) && Objects.equals(value, mapEntry.value);
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }

    @Override
    public String toString() {
        return  key +
                "=" + value;
    }

    @Override
    public int compareTo(MapEntry<K, V> kvMapEntry) {
        return Integer.compare(this.hashCode(), kvMapEntry.hashCode());
    }
}
