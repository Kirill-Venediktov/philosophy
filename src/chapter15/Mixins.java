package chapter15;

import chapter2.DataOnly;

import java.util.Date;

interface TimeStamped {
    long getStamp();
}

class TimeStampImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampImp() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}
class SerialNumberdImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Colored {
    boolean isColored();

}

class ColoredImp implements Colored {
    boolean hasColor;

    public boolean setColor(boolean sets){
        this.hasColor = sets;
        return hasColor;
    }

    @Override
    public boolean isColored() {
        return hasColor;
    }
}

interface Basic {
    void set(String val);
    String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        this.value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Colored {
    private TimeStamped timeStamp = new TimeStampImp();
    private SerialNumbered serialNumber = new SerialNumberdImp();
    private ColoredImp coloredImp = new ColoredImp();

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public boolean isColored() {
        return coloredImp.isColored();
    }

    public boolean setColor (boolean sets){
        coloredImp.setColor(sets);
        return coloredImp.isColored();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        mixin1.setColor(true);
        System.out.println(mixin1.get() + " " +
                mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " + mixin1.isColored());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() +
                " " + mixin2.getSerialNumber() + " " + mixin2.isColored());
    }
}
