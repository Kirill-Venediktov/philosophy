package chapter5;

public class Task14 {
    static String string = "Hello";
    static Moon moon;
    static {
        moon = new Moon();
    }

    static void showInfo(){
        System.out.println(string);
        moon.rotate();
    }
}

class Moon{
    Moon(){
        System.out.println("Hello, im Moon");
    }

    public void rotate(){
        System.out.println("look, im rotating");
    }
}

class Test{
    public static void main(String[] args) {
        Task14.showInfo();
    }
}