package chapter10;

public class Task8 {


    class Inner {
        private String string = "PrivateString";
    }

    public void f(){
        Inner inner = new Inner();
        inner.string = "qwerty";
    }
}
