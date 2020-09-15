package sword.offer.day7;

/**
 * 股票的最大利润
 * @author youtiaoguagua
 * @date 2020/9/15 16:50
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖 一次 该股票可能获得的利润是多少？
 * 例如一只股票在某些时间节点的价格为[9, 11, 8, 5, 7, 12, 16, 14]。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 * 样例
 * 输入：[9, 11, 8, 5, 7, 12, 16, 14]
 * 输出：11
 */
public class MaxDiff {
    public int maxDiff(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        //股票的最小价格
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res =0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.min(nums[i], dp[i-1]);
            res = Math.max(res, nums[i] - dp[i]);
        }
        return res;
    }
}
