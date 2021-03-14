package chapter15;


import java.util.Queue;

interface FactoryI<T,A> {
    T create(A a);
}

class Foo2<T,A> {
    private T x;
    public <F extends FactoryI<T,A>> Foo2(F factory, A q) {
        x = factory.create(q);
    }
}

class IntegerFactory implements FactoryI<Integer, Integer> {
    @Override
    public Integer create(Integer integer) {
        return new Integer(integer);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget,String> {

        @Override
        public Widget create(String s) {
            System.out.println(s);
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer,Integer>(new IntegerFactory(),45);
        new Foo2<Widget, String>(new Widget.Factory(), "Привет, пиздюки");
    }
}
