package chapter11;

import java.util.Map;

public class Task23 {

    public static void inspectorStatistics(Map<Integer,Integer> map){
        while (true){
            int max = 0;
            int numericMax = 0;
            boolean equals = false;
            for (Map.Entry<Integer,Integer> entry : map.entrySet() ){
                if (max < entry.getValue()){
                    max = entry.getValue();
                    numericMax = entry.getKey();
                    equals = false;
                    continue;
                }
                if (max == entry.getValue()){
                    equals = true;
                }
            }
            if (equals){
                System.out.println("Пока нет числа, появляющегося раньше других");
            }
            if (!equals){
                System.out.println("Обнаружено число, появляющееся чаще других - " + numericMax + "," +
                        " оно встречается " + max + " раз");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = Statistics.getStatisticMap();
       inspectorStatistics(map);
    }
}
