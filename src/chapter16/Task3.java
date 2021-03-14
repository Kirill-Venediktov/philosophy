package chapter16;

import java.util.Arrays;


public class Task3 {
    double[][] doubles;
    double[][][] doublesTask3;

    public void arrayInitializationVar1(int size1, int size2, int start, int end ) throws Exception {
        if (start - end > 0) {
            throw new Exception("start должен быть меньше end ");
        }
        if (size1 == 0 || size2 == 0) {
            throw new Exception("Размер не может быть нулевым");
        }
        doubles = new double[size1][];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = new double[size2];
            for (int j = 0; j < doubles[i].length; j++) {
                doubles[i][j] = start + (Math.random()*(end - start));
            }
        }
    }

    public void arrayInitializationVar2(int size1, int size2, int size3, int start, int end) throws Exception {
        if (start - end > 0) {
            throw new Exception("start должен быть меньше end ");
        }
        if (size1 == 0 || size2 == 0 || size3 == 0) {
            throw new Exception("Размер не может быть нулевым");
        }
        doublesTask3 = new double[size1][][];
        for (int i = 0; i < doublesTask3.length; i++) {
            doublesTask3[i] = new double[size2][];
            for (int j = 0; j < doublesTask3[i].length; j++) {
                doublesTask3[i][j] = new double[size3];
                for (int k = 0; k < doublesTask3[i][j].length; k++) {
                    doublesTask3[i][j][k] = start + (Math.random() * (end - start));
                }
            }
        }
    }

    public void show2DArray() {
        System.out.println(Arrays.deepToString(doubles));
    }

    public void show3DArray() {
        System.out.println(Arrays.deepToString(doublesTask3));
    }





    public static void main(String[] args) {
        Task3 task3 = new Task3();
        try {
            task3.arrayInitializationVar1(5,7, 4,6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        task3.show2DArray();

        try {
            task3.arrayInitializationVar2(2,2,3,3,4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        task3.show3DArray();
    }
}
