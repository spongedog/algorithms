package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2020/11/17
 */
public class Leetcode406 {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{
                new int[]{7, 0},
                new int[]{4, 4},
                new int[]{7, 1},
                new int[]{5, 0},
                new int[]{6, 1},
                new int[]{5, 2},
        };
        Leetcode406.reconstructQueue(people);
    }
}
