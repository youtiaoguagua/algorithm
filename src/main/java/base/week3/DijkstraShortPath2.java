package base.week3;

/**
 * Dijkstra求最短路 II
 * @author youtiaoguagua
 * @date 2020/9/24 10:30
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环，所有边权均为非负值。
 * 请你求出1号点到n号点的最短距离，如果无法从1号点走到n号点，则输出-1。
 * 输入格式
 * 第一行包含整数n和m。
 * 接下来m行每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。
 * 输出格式
 * 输出一个整数，表示1号点到n号点的最短距离。
 * 如果路径不存在，则输出-1。
 * 数据范围
 * 1≤n,m≤1.5×105,
 * 图中涉及边长均不小于0，且不超过10000。
 * 输入样例：
 * 3 3
 * 1 2 2
 * 2 3 1
 * 1 3 4
 * 输出样例：
 * 3
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
public class DijkstraShortPath2 {
    static int n;
    static int[] dist;
    static boolean[] conf;
    static ArrayList<ArrayList<Paris>> map = new ArrayList<>();

    public static void add(int a, int b,int c) {
        ArrayList<Paris> list = map.get(a);
        list.add(new Paris(b,c));
    }

    public static int dijkstra(){
        PriorityQueue<Paris> queue = new PriorityQueue<>((a,b)->a.b-b.b);
        queue.add(new Paris(0, 1));
        while (!queue.isEmpty()){
            Paris poll = queue.poll();
            if (conf[poll.c]){
                continue;
            }
            conf[poll.c] = true;
            ArrayList<Paris> pairs = map.get(poll.c);
            for (Paris pair : pairs) {
                if (dist[pair.b] > poll.b+ pair.c){
                    dist[pair.b] = poll.b + pair.c;
                    queue.add(new Paris(dist[pair.b], pair.b));
                }
            }
        }
        if (dist[n]==10000000){
            return -1;
        }
        return dist[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        dist = new int[n+1];
        conf = new boolean[n+1];
        Arrays.fill(dist,10000000);
        dist[1] = 0;
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
        int dijkstra = dijkstra();
        System.out.println(dijkstra);
    }


    static public class Paris {
        int b;
        int c;

        public Paris(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }
}
