package chapter16;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenericType<T> {
    List<T> list;
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        list = new ArrayList<>();
        list = (List<T>) new ArrayList<Object>();

    }
//    public <U> U[] makeArray() {return  new U[10];}
    public <U> ArrayList<U> makeList(){
        return new ArrayList<U>();
    }
}
