package base.week4;

import java.util.Scanner;

/**
 * 筛法求欧拉函数
 * @author youtiaoguagua
 * @date 2020/9/26 11:05
 * 给定一个正整数n，求1~n中每个数的欧拉函数之和。
 *
 * 输入格式
 * 共一行，包含一个整数n。
 *
 * 输出格式
 * 共一行，包含一个整数，表示1~n中每个数的欧拉函数之和。
 *
 * 数据范围
 * 1≤n≤106
 * 输入样例：
 * 6
 * 输出样例：
 * 12
 */
public class EulerFunctionSum {
    static boolean[] st;
    static int[] prim;
    static long[] yue;
    static int idx=0;

    public static void eulerSum(int n){
        yue[1] =1;
        for (int i = 2; i <=n ; i++) {
            if (!st[i]){
                prim[idx++] = i;
                yue[i] = i-1;
            }
            for (int j = 0; prim[j]<=n/i; j++) {
                int t = prim[j]*i;
                st[t] = true;

                if (i%prim[j]==0){
                    yue[t] = prim[j]*yue[i];
                    break;
                }
                //yue[t] = prim[j]*yue[i]*(1-1/prim[j]);
                yue[t] = yue[i]*(prim[j]-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        st = new boolean[n + 1];
        prim = new int[n + 1];
        yue = new long[n+1];
        eulerSum(n);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res+=yue[i];
        }
        System.out.println(res);
    }
}
