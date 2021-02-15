package chapter7;

public class Amphibian {

    public static void whoisThis(Amphibian amphibian){
        System.out.println("This is amphibian");
        System.out.println(amphibian.toString());
    }

    @Override
    public String toString() {
        return "Amphibian{}";
    }

    public void speak(){
        System.out.println("Amphibean speaks");
    }

    public void jump(){
        System.out.println("Amphibean jumps");
    }

    public void swim(){
        System.out.println("Amphibean swims");
    }

    public static void main(String[] args) {
        Amphibian frog = new Frog();
        frog.jump();
        frog.speak();
        frog.swim();
        whoisThis(frog);
    }
}

class Frog extends Amphibian {
    @Override
    public void speak() {
        System.out.println("Frog speaking");
    }

    @Override
    public void jump() {
        System.out.println("Frog jumping");
    }

    @Override
    public void swim() {
        System.out.println("Frog swiming");
    }

    @Override
    public String toString() {
        return "Frog{}";
    }
}