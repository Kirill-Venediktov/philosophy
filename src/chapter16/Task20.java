package chapter16;

import java.util.Arrays;

public class Task20 {
    public static void main(String[] args) {
        Task19Test[][][] task19Tests1 = new Task19Test[3][4][3];
        Task19Test[][][] task19Tests2 = new Task19Test[3][4][3];

        for (int i = 0; i < task19Tests1.length; i++){
            for (int j = 0; j < task19Tests1[i].length; j++){
                for (int k = 0; k < task19Tests1[i][j].length; k++) {
                    task19Tests1[i][j][k] = new Task19Test(4);
                }
            }
        }

        System.arraycopy(task19Tests1, 0, task19Tests2, 0, task19Tests1.length);
        System.out.println(Arrays.deepToString(task19Tests1));
        System.out.println(Arrays.deepToString(task19Tests2));

        System.out.println(Arrays.deepEquals(task19Tests1, task19Tests2));
    }
}
