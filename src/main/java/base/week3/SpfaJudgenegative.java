package base.week3;

/**
 * spfa判断负环
 * @author youtiaoguagua
 * @date 2020/9/24 18:06
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 * 请你判断图中是否存在负权回路。
 * 输入格式
 * 第一行包含整数n和m。
 * 接下来m行每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。
 * 输出格式
 * 如果图中存在负权回路，则输出“Yes”，否则输出“No”。
 * 数据范围
 * 1≤n≤2000 ,
 * 1≤m≤10000,
 * 图中涉及边长绝对值均不超过10000。
 * 输入样例：
 * 3 3
 * 1 2 -1
 * 2 3 4
 * 3 1 -4
 * 输出样例：
 * Yes
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class SpfaJudgenegative {
    static int n,m,index;
    static int[] e,w,ne,h,dist;
    static boolean[] st;
    static int[] count;

    private static void add(int a, int b, int c) {
        e[index] = b;
        w[index] = c;
        ne[index] = h[a];
        h[a] = index++;
    }

    public static boolean spfa(){
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            st[i] = true;
        }

        while (!queue.isEmpty()){
            Integer pop = queue.pollFirst();
            st[pop] = false;
            for (int i = h[pop]; i !=-1; i = ne[i]) {
                int j = e[i];
                count[j] = count[pop]+1;
                if (count[j]>=n){
                    return true;
                }
                if (dist[j]>dist[pop]+w[i]){
                    dist[j] = dist[pop]+w[i];
                    queue.add(j);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        e = new int[2000];
        w = e.clone();
        ne = e.clone();
        h = e.clone();
        Arrays.fill(h, -1);
        count = e.clone();
        dist = new int[n+1];
        st = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            add(a,b,c);
        }
       if ( spfa()){
           System.out.println("Yes");
       }else {
           System.out.println("No");
       }
    }
}
