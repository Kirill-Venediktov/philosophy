package chapter16;

public class Task8<T> {
    T[] array;
    @SuppressWarnings("unchecked")
    public void ArrayOfGenericType(int size) {
        array = (T[]) new Object[size];
    }
    public static void main(String[] args) {
        Task8<BerylliumSphere> berylliumSphereTask8 = new Task8<>();
        berylliumSphereTask8.ArrayOfGenericType(4);

        String[] strings = new String[4];
        Object[] objects = new Object[3];

        strings[0] = "ffg";
//        strings[1]= new BerylliumSphere();

        objects[0] = "gfgf";
        objects[1] = new BerylliumSphere();

    }
}
