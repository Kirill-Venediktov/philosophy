package util;

import java.util.*;

public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        if (size < 0) size = 0;
        this.size = size;
    }
    private static class Entry implements Map.Entry<Integer, String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return
                    chars[index % chars.length] +
                    Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String s) {
            throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
        private int size;

        public EntrySet(int size) {
            if(size < 0) {
                size = 0;
            }
            this.size = size;
        }
        private class Iter implements Iterator<Map.Entry<Integer, String>> {
            private Entry entry = new Entry(-1);
            @Override
            public boolean hasNext() {
                return entry.index < size - 1;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }
        }
        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }
    }
    private static Set<Map.Entry<Integer, String>> entries = new EntrySet(chars.length);

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
//        Set<Map.Entry<Integer, String>> entries =
//                new LinkedHashSet<>();
//        for (int i = 0; i < size; i++) {
//            entries.add(new Entry(i));
//        }
        return entries;
    }
    static Map<Integer, String> select(final int size) {
        return new CountingMapData(size) {
            public Set<Map.Entry<Integer, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    public static void main(String[] args) {
//        System.out.println(new CountingMapData(60));
        System.out.println(select(60));
    }
}
