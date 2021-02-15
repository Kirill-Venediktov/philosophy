package chapter5;

public enum Valute {
    RUBLE, FRANK, DOLLAR, POUND, EURO, GRIVNA
}

class TestValute{

    static void valuteDescribe(Valute valute){
        System.out.print("Это валюта ");
        switch (valute) {
            case DOLLAR:
                System.out.println("USA valute");
                break;
            case EURO:
                System.out.println("European union valute");
                break;
            case FRANK:
                System.out.println("valute of France");
                break;
            case POUND:
                System.out.println("British valute");
                break;
            case GRIVNA:
                System.out.println("Ukrainan valute");
                break;
            case RUBLE:
                System.out.println("Shit");
                break;
                default:
                    System.out.println("Чет хер знает");
        }
    }

    public static void main(String[] args) {
        for (Valute valute : Valute.values()){
            System.out.println(valute + " ordinal: " + valute.ordinal());
        }

        valuteDescribe(Valute.FRANK);
        valuteDescribe(Valute.POUND);
        valuteDescribe(Valute.RUBLE);

    }
}

