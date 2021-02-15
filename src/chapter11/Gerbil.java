package chapter11;

import java.util.ArrayList;
import java.util.Iterator;

public class Gerbil {
    private int gerbilnumber;

    @Override
    public String toString() {
        return "Gerbil{" +
                "gerbilnumber=" + gerbilnumber +
                '}';
    }

    public Gerbil(int gerbilnumber) {
        this.gerbilnumber = gerbilnumber;
    }

    void pop(){
        System.out.println("Gerbil number = " + gerbilnumber);
    }

    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for(int i = 0; i<10; i++){
            gerbils.add(new Gerbil(i));
        }
        Iterator<Gerbil> iterator = gerbils.iterator();
        while (iterator.hasNext()){
            iterator.next().pop();
        }
    }
}
