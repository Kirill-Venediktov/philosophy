package chapter15.storyCharacters;

import chapter15.coffee.CoffeeGenerator;
import util.Generator;

import java.util.Iterator;
import java.util.Random;

public class StoryCharactersGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {
    private Class[] types = {Bober.class, DyadyaFedor.class, Matroskin.class, Pechkin.class, Sharik.class};
    private static Random random = new Random();

    public StoryCharactersGenerator() {
    }
    private int size = 0;

    public StoryCharactersGenerator(int size) {
        this.size = size;
    }

    @Override
    public Iterator<StoryCharacters> iterator() {
        return new StoryCharactersIterator();
    }

    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
        class StoryCharactersIterator implements Iterator<StoryCharacters> {
        int count = size;
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public StoryCharacters next() {
                count--;
                return StoryCharactersGenerator.this.next();
            }
        }

    public static void main(String[] args) {
        StoryCharactersGenerator generator = new StoryCharactersGenerator();
        for (int i = 0; i < 5; i++){
            System.out.println(generator.next());
        }
        for (StoryCharacters sc : new StoryCharactersGenerator(5)){
            System.out.println(sc);
        }
    }
}
