package base.week3;

/**
 * spfa求最短路
 * @author youtiaoguagua
 * @date 2020/9/24 16:11
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 * 请你求出1号点到n号点的最短距离，如果无法从1号点走到n号点，则输出impossible。
 * 数据保证不存在负权回路。
 * 输入格式
 * 第一行包含整数n和m。
 * 接下来m行每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。
 * 输出格式
 * 输出一个整数，表示1号点到n号点的最短距离。
 * 如果路径不存在，则输出”impossible”。
 * 数据范围
 * 1≤n,m≤105,
 * 图中涉及边长绝对值均不超过10000。
 * 输入样例：
 * 3 3
 * 1 2 5
 * 2 3 -3
 * 1 3 4
 * 输出样例：
 * 2
 */
import java.util.*;

public class SpfaUseQuick {
    static int n;
    static int m;
    static int[] e,w,ne,h,dist;
    static int idx=0;
    static boolean[] st;


    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }

    public static void spfa(){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        st[1] = true;
        while (!queue.isEmpty()) {
            Integer pop = queue.pop();
            st[pop] = false;
            for (int i = h[pop]; i !=-1; i = ne[i]) {
                int j = e[i];
                if (dist[j]>dist[pop]+w[i]){
                    dist[j] = dist[pop]+w[i];
                    queue.add(j);
                }
            }
        }
        if (dist[n]>=10000*m){
            System.out.println("impossible");
        }else {
            System.out.println(dist[n]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        e= new int[m+1];
        w = e.clone();
        ne = e.clone();
        h = e.clone();
        Arrays.fill(h,-1);
        dist = new int[n + 1];
        Arrays.fill(dist,10000*m);
        dist[1] = 0;
        st = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
        spfa();

    }
}
