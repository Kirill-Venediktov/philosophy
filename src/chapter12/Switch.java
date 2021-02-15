package chapter12;

public class Switch {
    private boolean state = false;

    public boolean read(){
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }
    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "вкл" : "выкл";
    }

}

class OnOffException1 extends Exception {
}

class OnOffException2 extends Exception {

}

class OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2{ }

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
            throw new RuntimeException();
        }catch (OnOffException1 e){
            System.out.println("OnOffException1");
            sw.off();
        }catch (OnOffException2 e2){
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}
