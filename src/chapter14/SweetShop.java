package chapter14;

import java.util.Scanner;

class Candy {
    static {
        System.out.println("Загрузка класса Candy");
    }
}

class Gum {
    static {
        System.out.println("Загрузка класса Gum");
    }
}

class Cookie {
    static {
        System.out.println("Загрузка класса Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
//        System.out.println("В методе main");
//        new Candy();
//        System.out.println("После создания Candy");
//        try {
//            Class.forName("chapter14.Gum");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Не удалось найти Gum");
//        }
//        System.out.println("После вызова метода Class.forName(\"Gum\")");
//        new Cookie();
//        System.out.println("После создания объекта Cookie");
        Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Введите название интересующего класса: ");
                Class.forName(scanner.next());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
}
