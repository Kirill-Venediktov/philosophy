package chapter8;

public class Cycle {
    public void ride(){
        System.out.println("Cycle rides");
    }

    public void wheels(){}

}

class Unicicle extends Cycle{
    @Override
    public void ride() {
        System.out.println("Unicicle rides");
    }

    @Override
    public void wheels() {
        System.out.println("Количество колес: 1");
    }

    public void balance(){
        System.out.println("Balance on unicycle");
    }
}

class Bicycle extends Cycle{
    @Override
    public void ride() {
        System.out.println("Bicycle rides");
    }

    @Override
    public void wheels() {
        System.out.println("Количество колес: 2");
    }

    public void balance(){
        System.out.println("Balance on bicycle");
    }
}

class Tricycle extends Cycle{
    @Override
    public void ride() {
        System.out.println("Tricycle rides");
    }

    @Override
    public void wheels() {
        System.out.println("Количество колес: 3");
    }
}

class Test{
    public static void go(Cycle cycle){
        cycle.ride();
        cycle.wheels();
    }

    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[]{
                new Unicicle(),
                new Bicycle(),
                new Tricycle()
        };

        for (Cycle cycle : cycles){
            ((Bicycle)cycle).balance();
        }
    }
}