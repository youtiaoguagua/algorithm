package base.week3;


/**
 * 走迷宫
 *
 * @author youtiaoguagua
 * @date 2020/9/22 19:46
 * 给定一个n*m的二维整数数组，用来表示一个迷宫，数组中只包含0或1，其中0表示可以走的路，1表示不可通过的墙壁。
 * 最初，有一个人位于左上角(1, 1)处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
 * 请问，该人从左上角移动至右下角(n, m)处，至少需要移动多少次。
 * 数据保证(1, 1)处和(n, m)处的数字为0，且一定至少存在一条通路。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 接下来n行，每行包含m个整数（0或1），表示完整的二维数组迷宫。
 * 输出格式
 * 输出一个整数，表示从左上角移动至右下角的最少移动次数。
 * 数据范围
 * 1≤n,m≤100
 * 输入样例：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出样例：
 * 8
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class WalkMaze {
    static int[][] nums;
    static int[][] dp;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        nums = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] ints = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nums[i] = ints;
        }
        int min = bfs();
        System.out.println(min);
    }

    private static int bfs() {
        LinkedList<Pair> list = new LinkedList<>();
        list.add(new Pair(0, 0));
        int[] a = {1, -1, 0, 0};
        int[] b = {0, 0, 1, -1};
        while (!list.isEmpty()) {
            Pair pair = list.pop();
            for (int i = 0; i < 4; i++) {
                int x = pair.x+a[i];
                int y = pair.y+b[i];
                if (x>=0&&x<n&&y>=0&&y<m&&nums[x][y]==0&&dp[x][y]==0){
                    dp[x][y] = dp[pair.x][pair.y]+1;
                    list.add(new Pair(x, y));
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
