package base.week4;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 筛质数
 * @author youtiaoguagua
 * @date 2020/9/25 22:19
 * 给定一个正整数n，请你求出1~n中质数的个数。
 * 输入格式
 * 共一行，包含整数n。
 * 输出格式
 * 共一行，包含一个整数，表示1~n中质数的个数。
 * 数据范围
 * 1≤n≤106
 * 输入样例：
 * 8
 * 输出样例：
 * 4
 */
public class SievePrimeNumber {
    static int count = 0;
    static boolean[] st;
    static int[] prim;

    public static void judge2(int n){
        for (int i = 2; i <=n ; i++) {
            if (!st[i]){
                prim[count++] = i;
            }
            for (int j = 0; prim[j]<=n/i ; j++) {
                st[prim[j]*i] =true;
                if (i%prim[j]==0){
                    break;
                }
            }
        }
    }

    public static void judge(int n){
        for (int i = 2; i <= n; i++) {
            if (!st[i]){
                count++;
                for (int j = i+i; j <=n; j+=i) {
                    st[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        st = new boolean[n+1];
        prim = new int[n + 1];
        judge2(n);
        System.out.println(count);
    }
}
