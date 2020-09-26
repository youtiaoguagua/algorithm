package base.week5;

import java.util.Scanner;

/**
 * 分组背包问题
 * @author youtiaoguagua
 * @date 2020/9/27 02:07
 * 有 N 组物品和一个容量是 V 的背包。
 * 每组物品有若干个，同一组内的物品最多只能选一个。
 * 每件物品的体积是 vij，价值是 wij，其中 i 是组号，j 是组内编号。
 * 求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 * 输入格式
 * 第一行有两个整数 N，V，用空格隔开，分别表示物品组数和背包容量。
 * 接下来有 N 组数据：
 * 每组数据第一行有一个整数 Si，表示第 i 个物品组的物品数量；
 * 每组数据接下来有 Si 行，每行有两个整数 vij,wij，用空格隔开，分别表示第 i 个物品组的第 j 个物品的体积和价值；
 * 输出格式
 * 输出一个整数，表示最大价值。
 * 数据范围
 * 0<N,V≤100
 * 0<Si≤100
 * 0<vij,wij≤100
 * 输入样例
 * 3 5
 * 2
 * 1 2
 * 2 4
 * 1
 * 3 4
 * 1
 * 4 5
 * 输出样例：
 * 8
 */
public class GroupBackPack {
    static int n,v,N=110;
    //每组的大小和价值
    static int[][] v1=new int[N][N],w1 =new int[N][N];
    //每组几个元素
    static int[] s =new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        v = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int num = scanner.nextInt();
            s[i] = num;
            for (int j = 0; j < num; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                v1[i][j] = a;
                w1[i][j] = b;
            }
        }
        bag();
    }

    private static void bag() {
        int[] dp = new int[v + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = v; j >=0; j++) {
                for (int k = 0; k < s[i]; k++) {
                    if (v1[i][k]<=j){
                        dp[j] = Math.max(dp[j], dp[j - v1[i][k]] + w1[i][k]);
                    }
                }
            }
        }
        System.out.println(dp[v]);
    }
}
