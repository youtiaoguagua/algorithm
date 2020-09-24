package base.week3;

/**
 * 有边数限制的最短路
 * @author youtiaoguagua
 * @date 2020/9/24 13:02
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 * 请你求出从1号点到n号点的最多经过k条边的最短距离，如果无法从1号点走到n号点，输出impossible。
 * 注意：图中可能 存在负权回路 。
 * 输入格式
 * 第一行包含三个整数n，m，k。
 * 接下来m行，每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。
 * 输出格式
 * 输出一个整数，表示从1号点到n号点的最多经过k条边的最短距离。
 * 如果不存在满足条件的路径，则输出“impossible”。
 * 数据范围
 * 1≤n,k≤500,
 * 1≤m≤10000,
 * 任意边长的绝对值不超过10000。
 * 输入样例：
 * 3 3 1
 * 1 2 1
 * 2 3 1
 * 1 3 3
 * 输出样例：
 * 3
 */
import java.util.Arrays;
import java.util.Scanner;
public class ShortWayLimit {
    static ThreeLe[] nums;
    static int[] dist;
    static int m;
    static int k;
    static int n;

    public static void bellmanFord(){
        for (int i = 0; i < k; i++) {
            int[] tmp = dist.clone();
            for (int j = 0; j < m; j++) {
                ThreeLe e = nums[j];
                dist[e.b]= Math.min(dist[e.b], tmp[e.a]+e.c);
            }
        }
        if (dist[n]>=m*500){
            System.out.println("impossible");
        }else {
            System.out.println(dist[n]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        nums = new ThreeLe[m];
        dist = new int[n+1];
        Arrays.fill(dist,5000000);
        dist[1] = 0;


        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            nums[i] = new ThreeLe(a,b,c);
        }
        bellmanFord();
    }

    static public class ThreeLe{
        int a,b,c;

        public ThreeLe(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
