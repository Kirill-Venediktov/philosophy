package util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <T> Set<T> union (Set<T> a, Set<T> b){
        if (a instanceof EnumSet){
            try {
                Set<T> result = ((EnumSet)a).clone();
                result.addAll(b);
                return result;
            }catch (Exception e){
                throw new RuntimeException();
            }

        } else {
            Set<T> result = new HashSet<>(a);
            result.addAll(b);
            return result;
        }

    }
}
