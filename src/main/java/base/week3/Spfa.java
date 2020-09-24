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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Spfa {
    static int n;
    static int m;
    static ArrayList<ArrayList<Pair>> map = new ArrayList<>();
    static boolean[] st;
    static int[] dist;

    public static void add(int a, int b, int c) {
        ArrayList<Pair> list = map.get(a);
        list.add(new Pair(b,c));
    }

    public static void spfa(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        st[1] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            st[poll] = false;
            ArrayList<Pair> list = map.get(poll);
            for (Pair pair : list) {
                if (dist[pair.b]>dist[poll]+pair.c){
                    dist[pair.b] = dist[poll] + pair.c;
                    if (!st[pair.b]){
                        queue.add(pair.b);
                        st[pair.b] = true;
                    }
                }
            }
        }
        if (dist[n]>=5000000){
            System.out.println("impossible");
        }else {
            System.out.println(dist[n]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        st = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist,5000000);
        dist[1] = 0;
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
    }

    static public  class Pair{
        int b,c;

        public Pair(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }
}
