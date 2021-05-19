package chapter17;

import util.RandomGenerator;

import java.util.*;

public class SetPerfomanceTask34 {
    static List<Test<Set<String>>> tests = new ArrayList<>();
    static RandomGenerator.String rgs = new RandomGenerator.String();
    static {
        tests.add(new Test<Set<String>>("add") {
            @Override
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++){
                    set.clear();
                    for (int j = 0; j < size; j++)
                        set.add(rgs.next());
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            @Override
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                String forContains = rgs.next();
                for (int i = 0; i < loops; i++)
                    for (int j = 0 ; j < span; j++)
                        set.contains(forContains);
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            @Override
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++){
                    Iterator<String> it = set.iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<String>(), tests);
        Tester.run(new HashSet<String>(), tests);
        Tester.run(new LinkedHashSet<String>(), tests);
    }
}
