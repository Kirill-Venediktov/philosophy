package chapter10;

public class Task17 {
    class Inner{
        class DeepInner{

        }
    }
}

class Task17_1 {
    static class AnotherInner{
        static class AnotherDeepInner{

        }
    }
}

class Task17_2 {
    public static void main(String[] args) {
        Task17_1.AnotherInner.AnotherDeepInner anotherDeepInner = new Task17_1.AnotherInner.AnotherDeepInner();
        Task17_1.AnotherInner anotherInner = new Task17_1.AnotherInner();
        Task17 task17 = new Task17();
        Task17.Inner inner = task17.new Inner();
        Task17.Inner.DeepInner deepInner = task17.new Inner().new DeepInner();
    }
}