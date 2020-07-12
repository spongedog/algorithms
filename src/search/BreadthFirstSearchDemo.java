package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author 郑凯努 date 2019/2/17
 */
public class BreadthFirstSearchDemo {

    int [][] maze;

    int [][] block;

    int [][] next = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    /**
     * 当前最小步数
     */
    int min;

    int targetX;

    int targetY;

    int mazeWidth;

    int mazeLength;

    private class Node {
        private int x;

        private int y;

        private int step;
    }

    private Queue<Node> stepQueue = new LinkedList<>();

    public BreadthFirstSearchDemo(int mazeWidth, int mazeLength) {
        var random = new Random();
        this.mazeWidth = mazeWidth;
        this.mazeLength = mazeLength;
        maze = new int[mazeWidth][mazeLength];
        block = new int[mazeWidth][mazeLength];
        for (int i = 0; i < mazeLength; i++) {
            for (int j = 0; j < mazeWidth; j++) {
                block[j][i] = random.nextInt(5);
                System.out.print(block[j][i]);
            }
            System.out.println();
        }
    }

    public int search(int startX, int startY, int targetX, int targetY) {
        min = Integer.MAX_VALUE;
        if (block[startX][startY] == 0 || block[targetX][targetY] == 0) {
            return min;
        }

        var node = new Node();
        node.x = startX;
        node.y = startY;
        node.step = 0;

        stepQueue.offer(node);

        int tx, ty;

        while (!stepQueue.isEmpty()) {
            var head = stepQueue.poll();
            for (int i = 0; i< next.length; i ++) {
                tx = head.x + next[i][0];
                ty = head.y + next[i][1];

                //越界，已在障碍物中或路径中，跳过
                if (tx < 0 || tx > mazeWidth - 1 || ty <0 || ty > mazeLength - 1 || block[tx][ty] == 0 || maze[tx][ty] == 1) {
                    continue;
                }

                maze[tx][ty] = 1;
                var tail = new Node();
                tail.x = tx;
                tail.y = ty;
                tail.step = head.step + 1;
                stepQueue.offer(tail);

                if (tail.x == targetX && tail.y == targetY) {
                    min = tail.step;
                    return min;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        var demo = new BreadthFirstSearchDemo(4, 6);
        System.out.println(demo.search(0,0, 3, 3));
    }
}
