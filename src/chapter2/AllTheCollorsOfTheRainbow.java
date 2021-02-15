package chapter2;

public class AllTheCollorsOfTheRainbow {
    int anIntegerRepresentingColors = 6;
    void changeTheHueOfTheColor(int newHue){
        anIntegerRepresentingColors += newHue;
    }

    public static void main(String[] args) {
        AllTheCollorsOfTheRainbow rainbow = new AllTheCollorsOfTheRainbow();
        System.out.println("Колличество цветов в радуге: " + rainbow.anIntegerRepresentingColors);
        rainbow.changeTheHueOfTheColor(2);
        System.out.println("Измененное количество цветов: " + rainbow.anIntegerRepresentingColors);


    }
}
