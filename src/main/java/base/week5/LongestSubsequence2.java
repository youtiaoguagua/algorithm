package base.week5;

import java.util.Scanner;

/**
 * 最长上升子序列 II
 * @author youtiaoguagua
 * @date 2020/9/27 14:00
 * 给定一个长度为N的数列，求数值严格单调递增的子序列的长度最长是多少。
 * 输入格式
 * 第一行包含整数N。
 * 第二行包含N个整数，表示完整序列。
 * 输出格式
 * 输出一个整数，表示最大长度。
 * 数据范围
 * 1≤N≤100000，
 * −109≤数列中的数≤109
 * 输入样例：
 * 7
 * 3 1 2 1 8 5 6
 * 输出样例：
 * 4
 */
public class LongestSubsequence2 {

    private static int n,N=100010;
    private static int[] a = new int[N];
    private static int[] p = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        solve();
    }

    private static void solve() {
        int len = 0;
        for (int i = 0; i < n; i++) {
            int left = 0,right=len;
            while (left < right) {
                int mid = (left+right+1)>>1;
                if (a[i]>p[mid]){
                    left = mid;
                }else {
                    right = mid-1;
                }
            }
            len = Math.max(len,right+1);
            p[right+1] = a[i];
        }
        System.out.println(len);
    }
}
