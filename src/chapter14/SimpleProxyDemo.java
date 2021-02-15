package chapter14;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        long startTime = System.currentTimeMillis();
        System.out.println("doSomething");
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время - " + (endTime-startTime) + " мс");
    }

    @Override
    public void somethingElse(String arg) {
        long startTime = System.currentTimeMillis();
        System.out.println("somethingElse " + arg);
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время - " + (endTime-startTime) + " мс");
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        long startTime = System.currentTimeMillis();
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время - " + (endTime-startTime) + " мс");
    }

    @Override
    public void somethingElse(String arg) {
        long startTime = System.currentTimeMillis();
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время - " + (endTime-startTime) + " мс");
    }
}

class SimpleProxyDemo {
    public static void consumer (Interface iface) {
        long startTime = System.currentTimeMillis();
        iface.doSomething();
        iface.somethingElse("bonobo");
        long endTime = System.currentTimeMillis();
        System.out.println("Затраченное время - " + (endTime-startTime) + " мс");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
