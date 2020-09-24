package base.week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Dijkstra求最短路 I
 * @author youtiaoguagua
 * @date 2020/9/23 08:49
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环，所有边权均为正值。
 * 请你求出1号点到n号点的最短距离，如果无法从1号点走到n号点，则输出-1。
 * 输入格式
 * 第一行包含整数n和m。
 * 接下来m行每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。
 * 输出格式
 * 输出一个整数，表示1号点到n号点的最短距离。
 * 如果路径不存在，则输出-1。
 * 数据范围
 * 1≤n≤500,
 * 1≤m≤105,
 * 图中涉及边长均不超过10000。
 * 输入样例：
 * 3 3
 * 1 2 2
 * 2 3 1
 * 1 3 4
 * 输出样例：
 * 3
 */
public class DijkstraShortPath {
    static int[][] nums;
    static int n;
    static int[] dist;
    static boolean[] conf;

    public static int dijkstra(){
        for (int i = 1; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!conf[j]&&(t==-1||dist[j]<dist[t])){
                    t = j;
                }
            }
            conf[t] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j],nums[t][j]+dist[t]);
            }
        }

        if (dist[n]==100000){
            return -1;
        }
        return dist[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n+1][n+1];
        dist = new int[n+1];
        conf = new boolean[n+1];
        Arrays.fill(dist,100000);
        dist[1] = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(nums[i],100000);
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            nums[a][b] = Math.min( nums[a][b],c);
        }
        int dijkstra = dijkstra();
        System.out.println(dijkstra);
    }
}
