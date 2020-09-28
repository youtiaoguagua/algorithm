package base.week5;

import java.util.Scanner;

/**
 * 最短编辑距离
 * @author youtiaoguagua
 * @date 2020/9/28 18:02
 * 给定两个字符串A和B，现在要将A经过若干操作变为B，可进行的操作有：
 * 删除–将字符串A中的某个字符删除。
 * 插入–在字符串A的某个位置插入某个字符。
 * 替换–将字符串A中的某个字符替换为另一个字符。
 * 现在请你求出，将A变为B至少需要进行多少次操作。
 * 输入格式
 * 第一行包含整数n，表示字符串A的长度。
 * 第二行包含一个长度为n的字符串A。
 * 第三行包含整数m，表示字符串B的长度。
 * 第四行包含一个长度为m的字符串B。
 * 字符串中均只包含大写字母。
 * 输出格式
 * 输出一个整数，表示最少操作次数。
 * 数据范围
 * 1≤n,m≤1000
 * 输入样例：
 * 10
 * AGTCTGACGC
 * 11
 * AGTAAGTAGGC
 * 输出样例：
 * 4
 */
public class ShortestEditDistance {

    private static int n;
    private static char[] a;
    private static int m;
    private static char[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        String s = scanner.next();
        char[] chars = s.toCharArray();
        a = new char[n+1];
        System.arraycopy(chars,0,a,1,chars.length);
        m = scanner.nextInt();
        chars = scanner.next().toCharArray();
        b = new char[m+1];
        System.arraycopy(chars,0,b,1,chars.length);
        solve();
    }

    private static void solve() {
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= m; i ++ ) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= n; i ++ ) {
            dp[i][0] = i;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                dp[i][j] = Math.min(dp[i - 1][j]+1, dp[i][j - 1]+1);
                if (a[i]==b[j]){
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j]);
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
