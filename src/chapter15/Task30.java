package chapter15;

public class Task30 {
    public static void main(String[] args) {
        Holder<Integer> integerHolder = new Holder<>();
        Holder<Long> longHolder = new Holder<>();
        Holder<Byte> byteHolder = new Holder<>();
        Holder<Short> shortHolder = new Holder<>();
        Holder<Character> characterHolder = new Holder<>();
        Holder<Float> floatHolder = new Holder<>();
        Holder<Double> doubleHolder = new Holder<>();
        Holder<Boolean> booleanHolder = new Holder<>();

        integerHolder.setValue(5);
        longHolder.setValue(5L);
        byteHolder.setValue((byte)5);
        shortHolder.setValue((short) 43);
        characterHolder.setValue('t');
        floatHolder.setValue(4.4f);
        doubleHolder.setValue(5.5);
        booleanHolder.setValue(true);

        System.out.println(integerHolder.getValue());
        System.out.println(longHolder.getValue());
        System.out.println(byteHolder.getValue());
        System.out.println(shortHolder.getValue());
        System.out.println(characterHolder.getValue());
        System.out.println(floatHolder.getValue());
        System.out.println(doubleHolder.getValue());
        System.out.println(booleanHolder.getValue());
    }
}
