package util;

public class SkipGenerator {
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;

        public Boolean(boolean value) {
            this.value = value;
        }

        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value = 0;
        private final byte offset;

        public Byte(byte offset) {
            this.offset = offset;
        }

        @Override
        public java.lang.Byte next() {
            return (byte)(value++ + offset);
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class Character implements Generator<java.lang.Character>{
        int index = -1;
        private final int offset;

        public Character(int offset) {
            this.offset = offset;
        }

        public java.lang.Character next() {
            index = (index + 1 + offset) % chars.length;
            return chars[index];
        }
    }
    public static class String implements Generator<java.lang.String> {
        private int length = 7;
        Generator<java.lang.Character> cg;

        public String(int offset) {
            cg = new SkipGenerator.Character(offset);
        }

        public String(int length, int offset) {
            this.length = length;
            cg = new SkipGenerator.Character(offset);
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i< length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }
    public static class Short implements Generator<java.lang.Short>{
        private final short offset;
        private short value = 0;

        public Short(short offset) {
            this.offset = offset;
        }

        @Override
        public java.lang.Short next() {
            return (short)(value++ + offset);
        }
    }
    public static class Integer implements Generator<java.lang.Integer> {
        private int value = 0;
        private final int offset;

        public Integer(int offset) {
            this.offset = offset;
        }

        @Override
        public java.lang.Integer next() {
            return value++ + offset;
        }
    }
    public static class Long implements Generator<java.lang.Long> {
        private long value = 0;
        private final long offset;

        public Long(long offset) {
            this.offset = offset;
        }

        @Override
        public java.lang.Long next() {
            return (value++ + offset);
        }
    }
    public static class Float implements Generator<java.lang.Float> {
        private float value = 0.0f;
        private final float offset;

        public Float(float offset) {
            this.offset = offset;
        }

        @Override
        public java.lang.Float next() {
            float result = value+offset;
            value += 1.0;
            return result;
        }
    }
    public static class Double implements Generator<java.lang.Double> {
        private double value = 0.0;
        private final double offset;

        public Double(double offset) {
            this.offset = offset;
        }

        @Override
        public java.lang.Double next() {
            double result = value + offset;
            value += 1.0;
            return result;
        }
    }
}
