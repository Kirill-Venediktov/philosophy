package chapter8.music3;

import java.util.Random;

interface Playable{
    void play(Note note);
}

abstract class Instrument {
   abstract String what();
    abstract void adjust();

    @Override
    public String toString() {
        return what();
    }
}

class Wind extends Instrument implements Playable{
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument implements Playable{
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument implements Playable{
    @Override
   public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind{
    @Override
   public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class Woodwind extends Wind {
    @Override
   public void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }

    @Override
    String what() {
        return "Woodwind";
    }
}

class Guitar extends Stringed {
    @Override
    public void play(Note n) {
        System.out.println("Guitar.play() " + n);
    }

    @Override
    String what() {
        return "Guitar";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Guitar");
    }
}

class RandomInstrumentGenerator {
    private Random random = new Random();
    public Playable next(){
        switch (random.nextInt(6)){
            default:
            case 0: return new Wind();
            case 1: return new Percussion();
            case 2: return new Stringed();
            case 3: return new Brass();
            case 4: return new Woodwind();
            case 5: return new Guitar();
        }
    }
}

public class Music3 {
    public static void tune(Playable playable){
        playable.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Playable[] playables){
        for(Playable playable : playables) {
            tune(playable);
        }
    }

    public static void whatAll(Instrument[] instruments){
        for(Instrument i : instruments) {
            System.out.println(i.toString());
        }
    }
    public static void main(String[] args) {
        Playable[] orchestra = new Playable[5];
        RandomInstrumentGenerator generator = new RandomInstrumentGenerator();
        for (int i = 0; i<orchestra.length; i++){
            orchestra[i] = generator.next();
        }
        tuneAll(orchestra);
    }
}
