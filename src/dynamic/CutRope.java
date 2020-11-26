package dynamic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/22
 */
public class CutRope {

    public static int cutRope(int target) {
        if (target < 2) {
            return 0;
        }

        if (target == 2) {
            return 1;
        }

        if (target == 3) {
            return 2;
        }

        int[] cache = new int[target + 1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 3;

        for (int i = 4; i < target + 1; i ++) {
            int res = 0;
            for (int j = 1; j < i/2 + 1; j ++) {
                res = Math.max(res, cache[j] * cache[i - j]);
            }
            cache[i] = res;
        }

        return cache[target];
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> occurrencesMap =
                Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Set<Long> occurrences = new HashSet<>();
        for (Long value : occurrencesMap.values()) {
            if (occurrences.contains(value)) {
                return false;
            }
            occurrences.add(value);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(CutRope.cutRope(6));
    }
}
