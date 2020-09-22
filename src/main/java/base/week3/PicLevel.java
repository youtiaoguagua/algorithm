package base.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 图中点的层次
 * @author youtiaoguagua
 * @date 2020/9/22 23:43
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环。
 * 所有边的长度都是1，点的编号为1~n。
 * 请你求出1号点到n号点的最短距离，如果从1号点无法走到n号点，输出-1。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 接下来m行，每行包含两个整数a和b，表示存在一条从a走到b的长度为1的边。
 * 输出格式
 * 输出一个整数，表示1号点到n号点的最短距离。
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 5
 * 1 2
 * 2 3
 * 3 4
 * 1 3
 * 1 4
 * 输出样例：
 * 1
 */
public class PicLevel {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int n;
    static int[] dp;

    public static void add(int a,int b){
        ArrayList<Integer> list = map.get(a);
        list.add(b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dp = new int[n+1];
        //Arrays.fill(dp,-1);
        int m = scanner.nextInt();
        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
        }

        int bfs = bfs(1);
        System.out.println(bfs);

    }

    private static int bfs(int x) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ArrayList<Integer> list = map.get(poll);
            for (Integer integer : list) {
                if (dp[integer]==0){
                    queue.add(integer);
                    dp[integer] = dp[poll]+1;
                }
            }
        }
        return dp[n]==0?-1:dp[n];
    }
}
