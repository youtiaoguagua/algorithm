package base.week5;

import java.util.Scanner;

/**
 * 石子合并
 * @author youtiaoguagua
 * @date 2020/9/28 21:38
 * 设有N堆石子排成一排，其编号为1，2，3，…，N。
 * 每堆石子有一定的质量，可以用一个整数来描述，现在要将这N堆石子合并成为一堆。
 * 每次只能合并相邻的两堆，合并的代价为这两堆石子的质量之和，合并后与这两堆石子相邻的石子将和新堆相邻，合并时由于选择的顺序不同，合并的总代价也不相同。
 * 例如有4堆石子分别为 1 3 5 2， 我们可以先合并1、2堆，代价为4，得到4 5 2， 又合并 1，2堆，代价为9，得到9 2 ，再合并得到11，总代价为4+9+11=24；
 * 如果第二步是先合并2，3堆，则代价为7，得到4 7，最后一次合并代价为11，总代价为4+7+11=22。
 * 问题是：找出一种合理的方法，使总的代价最小，输出最小代价。
 * 输入格式
 * 第一行一个数N表示石子的堆数N。
 * 第二行N个数，表示每堆石子的质量(均不超过1000)。
 * 输出格式
 * 输出一个整数，表示最小代价。
 * 数据范围
 * 1≤N≤300
 * 输入样例：
 * 4
 * 1 3 5 2
 * 输出样例：
 * 22
 */
public class StoneMerger {

    private static int[] s;
    private static int n,max = (int) 1e8;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] nums = new int[n +1];
        s = new int[n +1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            s[i] =nums[i]+s[i-1];
        }
        solve();
    }

    private static void solve() {
        dp = new int[n+1][n+1];
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j+i-1 <=n ; j++) {
                int l = j,r= j+i-1;
                dp[l][r] = max;
                for (int k = l; k <r ; k++) {
                    dp[l][r] = Math.min(dp[l][r],dp[l][k]+dp[k+1][r]+s[r]-s[l-1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}