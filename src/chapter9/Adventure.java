package chapter9;

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

interface CanClimb {
    void climb();
}

class ActionCharacter {
    public void fight() {

    }
}

class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim, CanClimb {
    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void climb() {

    }
}

public class Adventure {
    public static void t(CanFight x) {
        x.fight();
    }
    public static void u(CanSwim x) {
        x.swim();
    }
    public static void v(CanFly x) {
        x.fly();
    }
    public static void w(ActionCharacter x) {
        x.fight();
    }
    public static void x (CanClimb x){
        x.climb();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
        x(hero);
    }
}
