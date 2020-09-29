package base.week5;

import java.util.Scanner;

/**
 * 整数划分
 * @author youtiaoguagua
 * @date 2020/9/29 01:31
 * 一个正整数n可以表示成若干个正整数之和，形如：n=n1+n2+…+nk，其中n1≥n2≥…≥nk,k≥1。
 * 我们将这样的一种表示称为正整数n的一种划分。
 * 现在给定一个正整数n，请你求出n共有多少种不同的划分方法。
 * 输入格式
 * 共一行，包含一个整数n。
 * 输出格式
 * 共一行，包含一个整数，表示总划分数量。
 * 由于答案可能很大，输出结果请对109+7取模。
 * 数据范围
 * 1≤n≤1000
 * 输入样例:
 * 5
 * 输出样例：
 * 7
 */
public class IntegerDivision {

    private static int n,mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        solve2();
    }

    private static void solve() {
        int[][] f = new int[n+1][n+1];
        for (int i = 0; i <= n; i ++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=n ; j++) {
                f[i][j] = f[i-1][j]%mod;
                if (j>=i){
                    f[i][j] = (f[i-1][j]+f[i][j-i])%mod;
                }
            }
        }
        System.out.println(f[n][n]);
    }

    public static void solve2(){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <=n ; j++) {
                dp[j] = (dp[j]+dp[j-i])%mod;
            }
        }
        System.out.println(dp[n]);
    }
}
