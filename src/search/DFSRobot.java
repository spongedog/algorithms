package search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/22
 */
public class DFSRobot {

    private static final int[] STEP = {0, 1, 0, -1, 0};

    public static int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0) {
            return 0;
        }

        int[][] mark = new int[rows][cols];

        int res = 0;

        return dfs(0, 0, rows, cols, threshold, mark, res);
    }

    private static boolean validate(int rows, int cols, int threshold) {
        return rows % 10 + rows / 10 + cols % 10 + cols / 10 <= threshold;
    }

    private static int dfs(int x, int y, int rows, int cols, int threshold,
                     int[][] mark, int res) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || mark[x][y] == 1 || !validate(x, y, threshold)) {
            return res;
        }

        mark[x][y] = 1;
        res += 1;

        for (int i = 0; i < STEP.length - 1; i ++) {
            res = dfs(x + STEP[i], y + STEP[i + 1], rows, cols, threshold, mark, res);
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(DFSRobot.movingCount(15, 20 ,20));
    }
}
