package base.week3;

/**
 * Prim算法求最小生成树
 * @author youtiaoguagua
 * @date 2020/9/24 23:17
 * 给定一个n个点m条边的无向图，图中可能存在重边和自环，边权可能为负数。
 * 求最小生成树的树边权重之和，如果最小生成树不存在则输出impossible。
 * 给定一张边带权的无向图G=(V, E)，其中V表示图中点的集合，E表示图中边的集合，n=|V|，m=|E|。
 * 由V中的全部n个顶点和E中n-1条边构成的无向连通子图被称为G的一棵生成树，其中边的权值之和最小的生成树被称为无向图G的最小生成树。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 接下来m行，每行包含三个整数u，v，w，表示点u和点v之间存在一条权值为w的边。
 * 输出格式
 * 共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出impossible。
 * 数据范围
 * 1≤n≤500,
 * 1≤m≤105,
 * 图中涉及边的边权的绝对值均不超过10000。
 * 输入样例：
 * 4 5
 * 1 2 1
 * 1 3 2
 * 1 4 3
 * 2 3 2
 * 3 4 4
 * 输出样例：
 * 6
 */
import java.util.Arrays;
import java.util.Scanner;
public class Prim {
    static int n;
    static int m;
    static int[][] nums;
    static int[] dist;
    static boolean[] st;
    static final int INF = 1000000;

    public static int prim() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <=n; j++) {
               if (!st[j]&&(t==-1||dist[t]>dist[j])){
                   t = j;
               }
            }
            if (i!=0&&dist[t]==INF){
                return INF;
            }

            if (i!=0){
                res+=dist[t];
            }
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j],nums[t][j] );
            }
            st[t] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        nums = new int[n + 1][n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist,INF);
        st = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(nums[i],Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            nums[b][a] = nums[a][b] = Math.min(nums[a][b], c);
        }
        int prim = prim();
        if (prim==INF){
            System.out.println("impossible");
        }else {
            System.out.println(prim);
        }
    }
}
