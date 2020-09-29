package base.week5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 没有上司的舞会
 *
 * @author youtiaoguagua
 * @date 2020/9/29 18:22
 * Ural大学有N名职员，编号为1~N。
 * 他们的关系就像一棵以校长为根的树，父节点就是子节点的直接上司。
 * 每个职员有一个快乐指数，用整数 Hi 给出，其中 1≤i≤N。
 * 现在要召开一场周年庆宴会，不过，没有职员愿意和直接上司一起参会。
 * 在满足这个条件的前提下，主办方希望邀请一部分职员参会，使得所有参会职员的快乐指数总和最大，求这个最大值。
 * 输入格式
 * 第一行一个整数N。
 * 接下来N行，第 i 行表示 i 号职员的快乐指数Hi。
 * 接下来N-1行，每行输入一对整数L, K,表示K是L的直接上司。
 * 输出格式
 * 输出最大的快乐指数。
 * 数据范围
 * 1≤N≤6000,
 * −128≤Hi≤127
 * 输入样例：
 * 7
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1 3
 * 2 3
 * 6 4
 * 7 4
 * 4 5
 * 3 5
 * 输出样例：
 * 5
 */
public class PromWithoutBoss {

    private static int n;
    private static int[] happy;
    private static boolean[] fa;
    static int[] h,ne,val;
    static int idx=0;
    static int[][] dp;

    public static void add(int a,int b){
        val[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dp = new int[n+1][2];
        happy = new int[n +1];
        val = new int[n+1];
        ne = val.clone();
        h = val.clone();
        fa =new boolean[n+1];
        Arrays.fill(h, -1);
        for (int i = 1; i <= n; i++) {
            happy[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(b,a);
            fa[a] = true;
        }
        int root =1;
        for (int i = 1; i <=n ; i++) {
            if (!fa[i]){
                root = i;
                break;
            }
        }

        dfs(root);
        int res= Math.max(dp[root][0],dp[root][1]);
        System.out.println(res);

    }

    private static void dfs(int root) {
        dp[root][1] = happy[root];
        for (int i = h[root]; i !=-1 ; i=ne[i]) {
            int j = val[i];
            dfs(j);
            dp[root][1] += dp[j][0];
            dp[root][0] += Math.max(dp[j][1], dp[j][0]);
        }
    }
}
