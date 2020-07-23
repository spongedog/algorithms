package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/17
 */
public class ThrowEggDemo {

    public int throwEgg(int eggNum, int floorNum) {
        Map<Integer, Integer> dict = new HashMap<>();
        return dp(eggNum, floorNum, dict);
    }

    public int dp(int eggNum, int floorNum, Map<Integer, Integer> dict) {
        if (floorNum == 0) {
            return 0;
        }

        if (eggNum == 1) {
            return floorNum;
        }

        if (dict.containsKey(eggNum)) {
            return dict.get(eggNum);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < floorNum; i ++) {
            res = Math.min(res, Math.max(dp(eggNum - 1, i - 1, dict), dp(eggNum, floorNum - i, dict) + 1));
        }

        dict.put(eggNum, res != Integer.MAX_VALUE ? res : -1);

        return dict.get(eggNum);
    }
}
