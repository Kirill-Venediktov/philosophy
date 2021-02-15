package chapter12;

public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
            throw  new RuntimeException();
        } catch (OnOffException1 exception1) {
            exception1.printStackTrace();
        } catch (OnOffException2 onOffException2) {
            onOffException2.printStackTrace();
        }finally {
            sw.off();
        }
    }
}
