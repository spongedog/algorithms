package search;

import java.util.Random;

/**
 * @author 郑凯努 date 2019/2/12
 */
public class DepthFirstSearchDemo {
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

    public DepthFirstSearchDemo(int mazeWidth, int mazeLength) {
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
        this.targetX = targetX;
        this.targetY = targetY;
        dfs(startX, startY, 0);
        return min;
    }

    public void dfs(int x, int y, int step) {

        if (x == targetX && y == targetY) {
            if (step < min) {
                min = step;
                System.out.println(min);
            }
            return;
        }

        int tx, ty;
        for (int i = 0; i< next.length; i ++) {
            tx = x + next[i][0];
            ty = y + next[i][1];

            //越界，已在障碍物中或路径中，跳过
            if (tx < 0 || tx > mazeWidth - 1 || ty <0 || ty > mazeLength - 1 || block[tx][ty] == 0 || maze[tx][ty] == 1) {
                continue;
            }

            maze[tx][ty] = 1;
            dfs(tx, ty ,step + 1);
            maze[tx][ty] = 0;
        }
    }

    public static void main(String[] args) {
        var demo = new DepthFirstSearchDemo(3, 6);
        demo.search(0,0, 2, 2);
    }
}
