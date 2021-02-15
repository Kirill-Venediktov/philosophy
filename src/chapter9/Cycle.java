package chapter9;

public interface Cycle {
    void go();
}
interface CycleFactory{
    Cycle getCycle();
}
class Unicycle implements Cycle{
    @Override
    public void go() {
        System.out.println("Unicycle runs");
    }
}

class Bicycle implements Cycle{
    @Override
    public void go() {
        System.out.println("Bicycle runs");
    }
}

class Tricycle implements Cycle{
    @Override
    public void go() {
        System.out.println("Tricycle runs");
    }
}

class UnicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

class Cycles{
    public static void runOnCycle(CycleFactory cycleFactory){
        cycleFactory.getCycle().go();
    }

    public static void main(String[] args) {
        runOnCycle(new TricycleFactory());
        runOnCycle(new BicycleFactory());
    }
}