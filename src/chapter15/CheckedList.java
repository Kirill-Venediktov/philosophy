package chapter15;

import chapter15.coffee.*;
import chapter15.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyCappuccino) {
        probablyCappuccino.add(new Mocha.Factory().create());
    }

    public static void main(String[] args) {
        List<Cappuccino> cappuccinos1 = new ArrayList<>();
        oldStyleMethod(cappuccinos1);
        List<Cappuccino> cappuccinos2 = Collections.checkedList(new ArrayList<Cappuccino>(), Cappuccino.class);
        try {
            oldStyleMethod(cappuccinos2);
        }catch (Exception e) {
            System.out.println(e);
        }
        List<chapter15.coffee.Coffee> pets = Collections.checkedList(new ArrayList<Coffee>(), chapter15.coffee.Coffee.class);
        pets.add(new Mocha.Factory().create());
        pets.add(new Cappuccino.Factory().create());
    }
}
