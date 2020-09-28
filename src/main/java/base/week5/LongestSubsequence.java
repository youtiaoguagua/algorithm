package base.week5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长上升子序列
 * @author youtiaoguagua
 * @date 2020/9/27 12:22
 * 给定一个长度为N的数列，求数值严格单调递增的子序列的长度最长是多少。
 * 输入格式
 * 第一行包含整数N。
 * 第二行包含N个整数，表示完整序列。
 * 输出格式
 * 输出一个整数，表示最大长度。
 * 数据范围
 * 1≤N≤1000，
 * −109≤数列中的数≤109
 * 输入样例：
 * 7
 * 3 1 2 1 8 5 6
 * 输出样例：
 * 4
 */
public class LongestSubsequence {
    static int[] nums;
    static int n;

    private static void longSub() {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]< nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        longSub();
    }
}
