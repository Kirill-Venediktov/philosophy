package chapter17;

import java.util.*;

public class FastTraversalLinkedList<E> extends AbstractList<E> {
    private LinkedList<E> linkedList = new LinkedList<>();
    private ArrayList<E> arrayList = new ArrayList<>();

    private LinkedList<E> toLinkedList() {
        linkedList.clear();
        linkedList.addAll(arrayList);
        arrayList.clear();
        return linkedList;
    }

    private ArrayList<E> toArrayList() {
        arrayList.clear();
        arrayList.addAll(linkedList);
        linkedList.clear();
        return arrayList;
    }

    @Override
    public boolean add(E e) {
        if (linkedList.size() < arrayList.size())
            toLinkedList();
        return linkedList.add(e);
    }

    @Override
    public E set(int index, E element) {
        if (linkedList.size() < arrayList.size())
            toLinkedList();
        return linkedList.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        if (linkedList.size() < arrayList.size())
            toLinkedList();
        linkedList.add(index, element);
    }

    @Override
    public E remove(int index) {
        if (arrayList.size() != 0)
            toLinkedList();
        return linkedList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        if (arrayList.size() < linkedList.size())
            toArrayList();
        return arrayList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        if (arrayList.size() < linkedList.size())
            toArrayList();
        return arrayList.lastIndexOf(o);
    }

    @Override
    public void clear() {
        if (linkedList.size() < arrayList.size())
            toLinkedList();
        linkedList.clear();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (linkedList.size() < arrayList.size())
            toLinkedList();
        return linkedList.addAll(index, c);
    }

    @Override
    public Iterator<E> iterator() {
        if (arrayList.size() < linkedList.size())
            toArrayList();
        return arrayList.iterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        if (arrayList.size() < linkedList.size())
            toArrayList();
        return arrayList.listIterator();
    }

    @Override
    public E get(int i) {
        if (arrayList.size() < linkedList.size())
            toArrayList();
        return arrayList.get(i);
    }

    @Override
    public int size() {
        if (arrayList.size() < linkedList.size())
            toArrayList();
        return arrayList.size();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (arrayList.size() < linkedList.size())
            toArrayList();
        return arrayList.listIterator(index);
    }

    @Override
    public boolean equals(Object o) {
        arrayList = new ArrayList<>(linkedList);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FastTraversalLinkedList<?> that = (FastTraversalLinkedList<?>) o;
        return Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), arrayList);
    }

    @Override
    public String toString() {
        arrayList = new ArrayList<>(linkedList);
        return "FastTraversalLinkedList{" +
                "arrayList=" + arrayList +
                '}';
    }
}
