package sword.offer.day7;

/**
 * 骰子的点数
 * @author youtiaoguagua
 * @date 2020/9/14 23:48
 * 将一个骰子投掷n次，获得的总点数为s，s的可能范围为n~6n。
 * 掷出某一点数，可能有多种掷法，例如投掷2次，掷出3点，共有[1,2],[2,1]两种掷法。
 * 请求出投掷n次，掷出n~6n点分别有多少种掷法。
 * 样例1
 * 输入：n=1
 * 输出：[1, 1, 1, 1, 1, 1]
 * 解释：投掷1次，可能出现的点数为1-6，共计6种。每种点数都只有1种掷法。所以输出[1, 1, 1, 1, 1, 1]。
 * 样例2
 * 输入：n=2
 * 输出：[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
 * 解释：投掷2次，可能出现的点数为2-12，共计11种。每种点数可能掷法数目分别为1,2,3,4,5,6,5,4,3,2,1。
 * 所以输出[1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]。
 */
public class NumberOfDice {


    /**
     * 优化版1
     */
    public int[] numberOfDice2(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        dp[0][0] =1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=6*i ; j++) {
                for (int k = 1; k <=6 ; k++) {
                    if (j-k>=0){
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }

        int[] res = new int[n * 6 - n + 1];
        for (int i = 1,j=0; i <= 6*n; i++,j++) {
            res[j] = dp[n][i];
        }
        return res;
    }

    private int[][] cache;

    public int[] numberOfDice(int n) {
        cache = new int[n + 1][6 * n + 1];
        int index = 0;
        int[] res = new int[6 * n - n + 1];
        for (int i = n; i <=6*n ; i++) {
            res[index] = dfs(n,i);
            index++;
        }
        return res;
    }

    private int dfs(int n, int s) {
        if (s<0){
            return 0;
        }
        if (n==0){
            return s == 0 ? 1 : 0;
        }
        if (cache[n][s]!=0){
            return cache[n][s];
        }

        int res = 0;

        for (int i = 1; i <=6 ; i++) {
            res +=dfs(n-1,s-i);
        }
        cache[n][s] = res;
        return res;
    }
}
