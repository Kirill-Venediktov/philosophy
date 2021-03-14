package chapter15;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Coffee{
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void drink() {
        System.out.println("Drink coffee");
    }
}

class Decorator extends Coffee {
   protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public void setValue(String value) {
        coffee.setValue(value);
    }

    public String getValue() {
        return coffee.getValue();
    }
}

class Cappuccino_Task38 extends Decorator {
    private int cappuccinatorTime;

    public Cappuccino_Task38(Coffee coffee) {
        super(coffee);
    }

    public void setCappuccinatorTime(int cappuccinatorTime) {
        this.cappuccinatorTime = cappuccinatorTime;
    }

    public int getCappuccinatorTime() {
        return cappuccinatorTime;
    }
}

class CoffeeWithDecorativeFoam extends Decorator {
    private boolean withFoam;

    public CoffeeWithDecorativeFoam(Coffee coffee) {
        super(coffee);
    }

    public boolean isWithFoam() {
        return withFoam;
    }

    public void setWithFoam(boolean withFoam) {
        this.withFoam = withFoam;
    }
}

class CoffeeWithChocolate extends Decorator{
    private double ChocolateWeight;

    public CoffeeWithChocolate(Coffee coffee) {
        super(coffee);
    }

    public double getChocolateWeight() {
        return ChocolateWeight;
    }

    public void setChocolateWeight(double chocolateWeight) {
        ChocolateWeight = chocolateWeight;
    }
}

class CoffeeWithCaramel extends Decorator {
    private final LocalTime timeOfCooking;

    public CoffeeWithCaramel(Coffee coffee) {
        super(coffee);
      this.timeOfCooking = LocalTime.now();
    }

    public String getTimeOfCooking() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return timeOfCooking.format(dtf);
    }
}

class CoffeeWithWhippedCream extends Decorator {
    private final String nameOfCream;
    public CoffeeWithWhippedCream(Coffee coffee, String nameOfCream) {
        super(coffee);
        this.nameOfCream = nameOfCream;
    }

    public String getNameOfCream() {
        return nameOfCream;
    }
}

public class Task38 {
    public static void main(String[] args) {
        CoffeeWithCaramel withCaramel = new CoffeeWithCaramel(new Coffee());
        CoffeeWithCaramel withCaramel2 = new CoffeeWithCaramel(new CoffeeWithChocolate(new Coffee()));
        System.out.println(withCaramel.getTimeOfCooking());
        System.out.println(withCaramel2.getTimeOfCooking());
        CoffeeWithDecorativeFoam withDecorativeFoam = new CoffeeWithDecorativeFoam(new CoffeeWithWhippedCream(new Coffee(), "Буйда"));
        withDecorativeFoam.setWithFoam(true);
        System.out.println(withDecorativeFoam.isWithFoam());
        withDecorativeFoam.drink();
    }
}
