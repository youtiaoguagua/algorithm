package base.week6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 区间覆盖
 * @author youtiaoguagua
 * @date 2020/10/1 13:29
 * 给定N个闭区间[ai,bi]以及一个线段区间[s,t]，请你选择尽量少的区间，将指定线段区间完全覆盖。
 * 输出最少区间数，如果无法完全覆盖则输出-1。
 * 输入格式
 * 第一行包含两个整数s和t，表示给定线段区间的两个端点。
 * 第二行包含整数N，表示给定区间数。
 * 接下来N行，每行包含两个整数ai,bi，表示一个区间的两个端点。
 * 输出格式
 * 输出一个整数，表示所需最少区间数。
 * 如果无解，则输出-1。
 * 数据范围
 * 1≤N≤105,
 * −109≤ai≤bi≤109,
 * −109≤s≤t≤109
 * 输入样例：
 * 1 5
 * 3
 * -1 3
 * 2 4
 * 3 5
 * 输出样例：
 * 2
 */
public class IntervalCoverage {

    private static int start;
    private static int end;
    private static int n;
    private static Range[] ranges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start = scanner.nextInt();
        end = scanner.nextInt();
        n = scanner.nextInt();
        ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ranges[i] = new Range(a,b);
        }
        solve();
    }

    private static void solve() {
        Arrays.sort(ranges,(a, b)->a.left-b.left);
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int left = i, right = Integer.MIN_VALUE;
            while (left<n&& ranges[left].left<=start){
                right=Math.max(right, ranges[left].right);
                left++;
            }

            if (right<start){
                res = -1;
                break;
            }

            res++;
            if (right>=end){
                flag = true;
                break;
            }

            start = right;

            i = left-1;
        }
        if (!flag){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }

    static public class Range{
        int left,right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
