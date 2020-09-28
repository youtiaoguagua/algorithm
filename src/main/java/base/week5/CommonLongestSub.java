package base.week5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长公共子序列
 * @author youtiaoguagua
 * @date 2020/9/27 16:06
 * 给定两个长度分别为N和M的字符串A和B，求既是A的子序列又是B的子序列的字符串长度最长是多少。
 * 输入格式
 * 第一行包含两个整数N和M。
 * 第二行包含一个长度为N的字符串，表示字符串A。
 * 第三行包含一个长度为M的字符串，表示字符串B。
 * 字符串均由小写字母构成。
 * 输出格式
 * 输出一个整数，表示最大长度。
 * 数据范围
 * 1≤N,M≤1000
 * 输入样例：
 * 4 5
 * acbd
 * abedc
 * 输出样例：
 * 3
 */
public class CommonLongestSub {

    private static int n,m;
    private static char[] a;
    private static char[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        String s = scanner.next();
        char[] tmp = s.toCharArray();
        a = new char[n + 1];
        System.arraycopy(tmp,0,a,1,tmp.length);
        s = scanner.next();
        tmp = s.toCharArray();
        b = new char[m + 1];
        System.arraycopy(tmp,0,b,1,tmp.length);
        solve();
    }

    private static void solve() {
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (a[i]==b[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - 1]+1);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
