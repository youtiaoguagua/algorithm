package base.week3;

/**
 * 树的重心
 * @author youtiaoguagua
 * @date 2020/9/22 21:51
 * 给定一颗树，树中包含n个结点（编号1~n）和n-1条无向边。
 * 请你找到树的重心，并输出将重心删除后，剩余各个连通块中点数的最大值。
 * 重心定义：重心是指树中的一个结点，如果将这个点删除后，剩余各个连通块中点数的最大值最小，那么这个节点被称为树的重心。
 * 输入格式
 * 第一行包含整数n，表示树的结点数。
 * 接下来n-1行，每行包含两个整数a和b，表示点a和点b之间存在一条边。
 * 输出格式
 * 输出一个整数m，表示重心的所有的子树中最大的子树的结点数目。
 * 数据范围
 * 1≤n≤105
 * 输入样例
 * 9
 * 1 2
 * 1 7
 * 1 4
 * 2 8
 * 2 5
 * 4 3
 * 3 9
 * 4 6
 * 输出样例：
 * 4
 */
import java.util.ArrayList;
import java.util.Scanner;
public class TreePoint {
    static ArrayList<Integer>[] map;
    static boolean[]  dp;

    public static void add(int a, int b) {
        ArrayList<Integer> list = map[a];
        list.add(b);
    }

    static int ans = Integer.MAX_VALUE;
    static int n;
    public static int dfs(int x){
        dp[x] = true;
        ArrayList<Integer> list = map[x];
        int sum =1;
        int t = 0;
        for (Integer tmp : list) {
            if (!dp[tmp]){
                int z = dfs(tmp);
                t = Math.max(t,z);
                sum+=z;

            }
        }
        t  = Math.max(t,n-sum);
        ans = Math.min(ans,t);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new ArrayList[n+1];
        dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 1; i <=n-1 ; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
            add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
}
