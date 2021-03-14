package chapter16;

import java.util.Arrays;

public class Task6 {
    public static BerylliumSphere[][] createBerilliumSphere2DArray(int size1, int size2) throws Exception {
        if (size1 == 0 || size2 == 0){
            throw new Exception("Размер не должен быть равен нулю");
        }
        BerylliumSphere[][] berylliumSpheres = new BerylliumSphere[size1][size2];
        for (int i = 0; i < berylliumSpheres.length; i++) {
            for (int j = 0; j < berylliumSpheres[i].length; j++) {
                berylliumSpheres[i][j] = new BerylliumSphere();
            }
        }
        return berylliumSpheres;
    }

    public static BerylliumSphere[][][] createBerilliumSphere3DArray(int size1, int size2, int size3) throws Exception {
        if (size1 == 0 || size2 == 0 || size3 == 0){
            throw new Exception("Размер не должен быть равен нулю");
        }
        BerylliumSphere[][][] berylliumSpheres = new BerylliumSphere[size1][size2][size3];
        for (int i = 0; i < berylliumSpheres.length; i++) {
            berylliumSpheres[i] = createBerilliumSphere2DArray(size2,size3);
        }
        return berylliumSpheres;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.deepToString(createBerilliumSphere2DArray(3,5)));
            System.out.println(Arrays.deepToString(createBerilliumSphere3DArray(4,6,6)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
