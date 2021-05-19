package chapter17;

public class SList<T> {
    private Node<T> sNode;

    public SList() {
        this.sNode = new Node<>();
    }

    public Node<T> getsNode() {
        return sNode;
    }

    public SListIterator<T> iterator() {
        return new SListIterator<T>(sNode);
    }

    @Override
    public String toString() {
        return "SList{" +
                "sNode=" + sNode +
                '}';
    }
}

class SListIterator<T> {
    private Node<T> node;

    public SListIterator(Node<T> node) {
        this.node = node;
    }


    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public boolean hasNext() {
        return this.node.getNode() != null;
    }

    public Node<T> next() {
        if (hasNext()){
            node = node.getNode();
        }else {
            this.node = this.node.setNode(new Node<>());
        }
        return node;
    }

    public void set(T t) {
        node.set(t);
    }

    public T get(){
        return node.get();
    }

    public void remove() {
        node.set(null);
    }

}


class Test1 {
    public static void main(String[] args) {
        SList<Integer> sList = new SList<>();
        SListIterator<Integer> si = sList.iterator();
        for (int i = 0; i < 10; i++) {
            si.set(i);
            si.next();
        }
        si = sList.iterator();
        while (si.hasNext()){
            System.out.println(si.get());
            si.next();
        }
        si = sList.iterator();
        for (int i = 0; i < 3; i++) {
            si.remove();
            si.next();
        }
        si = sList.iterator();
        System.out.println("------");
        for (int i = 0; i < 5; i++) {
            System.out.println(si.get());
            si.next();
        }
    }
}

class Node<T> {
    private Node<T> node;
    private T t;

    public Node(Node<T> node, T t) {
        this.node = node;
        this.t = t;
    }

    public Node(T t) {
        this.t = t;
        this.node = null;
    }

    public Node() {
        this.node = null;
        this.t = null;
    }

    public Node<T> getNode() {
        return node;
    }

    public Node<T> setNode(Node<T> node) {
        this.node = node;
        return node;
    }

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public boolean haveNextNode() {
        return this.node != null;
    }
}


