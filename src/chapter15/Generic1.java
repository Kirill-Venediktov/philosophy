package chapter15;

import chapter14.pets.Pet;
import chapter14.pets.Task15_PetCreator2;

class Generic1<T> {
   private T x;

   public void method (T t) {
        this.x = t;
    }

}

class Generic2<T> {
    private T x;

    public T method () {
        return x;
    }

    public <T> void method2 (Generic1<? super T> generic, T t) {
        generic.method(t);
    }

    public static void main(String[] args) {
        Generic2<Pet> petGeneric2 = new Generic2<>();
        petGeneric2.method2(new Generic1<Pet>(), new Task15_PetCreator2().randomPet());
    }

}
