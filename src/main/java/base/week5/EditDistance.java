package base.week5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 编辑距离
 * @author youtiaoguagua
 * @date 2020/9/28 21:17
 * 给定n个长度不超过10的字符串以及m次询问，每次询问给出一个字符串和一个操作次数上限。
 * 对于每次询问，请你求出给定的n个字符串中有多少个字符串可以在上限操作次数内经过操作变成询问给出的字符串。
 * 每个对字符串进行的单个字符的插入、删除或替换算作一次操作。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 接下来n行，每行包含一个字符串，表示给定的字符串。
 * 再接下来m行，每行包含一个字符串和一个整数，表示一次询问。
 * 字符串中只包含小写字母，且长度均不超过10。
 * 输出格式
 * 输出共m行，每行输出一个整数作为结果，表示一次询问中满足条件的字符串个数。
 * 数据范围
 * 1≤n,m≤1000,
 * 输入样例：
 * 3 2
 * abc
 * acd
 * bcd
 * ab 1
 * acbd 2
 * 输出样例：
 * 1
 * 3
 */
public class EditDistance {

    private static int n;
    private static int m;
    private static String[] data;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        data = new String[n];
        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            data[i] = next;
        }
        for (int i = 0; i < m; i++) {
            String s = scanner.next();
            int time = scanner.nextInt();
            solve(s,time);
        }
    }

    private static void solve(String s, int time) {
        int res = 0;
        for (String datum : data) {
            int[][] dp =  new int[s.length()+1][datum.length()+1];
            char[] a = new char[s.length() + 1];
            char[] b = new char[datum.length() + 1];
            System.arraycopy(s.toCharArray(),0,a,1,s.length());
            System.arraycopy(datum.toCharArray(),0,b,1,datum.length());
            for (int i = 0; i <= s.length(); i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= datum.length(); i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <=s.length() ; i++) {
                for (int j = 1; j <= datum.length(); j++) {
                    dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                    if (a[i]==b[j]){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                    }else {
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                    }
                }
            }
            if (dp[s.length()][datum.length()]<=time){
                res++;
            }
        }
        System.out.println(res);
    }
}
