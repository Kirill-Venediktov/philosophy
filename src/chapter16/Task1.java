package chapter16;


public class Task1<T> {
    public void showArray(T[] ts) {
        for (int i = 0; i < ts.length; i++) {
            System.out.println(ts[i]);
        }
    }

    public static void main(String[] args) {
        Task1<BerylliumSphere> berylliumSphereTask1 = new Task1<>();
        berylliumSphereTask1.showArray(new BerylliumSphere[] {new BerylliumSphere(), new BerylliumSphere()});
//        berylliumSphereTask1.showArray(BerylliumSphere b = {new BerylliumSphere(), new BerylliumSphere()});


    }
}
