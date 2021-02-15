package chapter3;

public class Dog5 {
    String name;
    String says;

    public static void main(String[] args) {
        Dog5 dog1 = new Dog5();
        Dog5 dog2 = new Dog5();

        dog1.name = "Spot";
        dog2.name = "Scuffy";

        dog1.says = "woof";
        dog2.says = "auf";

        System.out.println(dog1.name);
        System.out.println(dog1.says);
        System.out.println(dog2.name);
        System.out.println(dog2.says);

        Dog5 dog3 = dog1;

        System.out.println(dog1 == dog3);
        System.out.println(dog1.equals(dog3));
    }
}
