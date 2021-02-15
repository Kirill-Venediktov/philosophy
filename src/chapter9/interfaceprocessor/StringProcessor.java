package chapter9.interfaceprocessor;

public abstract class StringProcessor implements Processor {
    public static String s = "If she weighs as a duck, shes made of wood";
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    public static void main(String[] args) {
        Apply.process(new Reverser(),s);
    }
}

class Reverser extends StringProcessor {

    @Override
    public Object process(Object input) {
        StringBuilder stringBuilder = new StringBuilder(input.toString());
        System.out.println(stringBuilder);
        for (int i = 1; i<stringBuilder.length(); i+=2){
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(stringBuilder.charAt(i));
            stringBuilder1.append(stringBuilder.charAt(i-1));
            stringBuilder.replace(i-1,i+1,stringBuilder1.toString());
        }
        return stringBuilder;
    }
}