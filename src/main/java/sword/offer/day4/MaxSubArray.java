package sword.offer.day4;

/**
 * 连续子数组的最大和
 * @author youtiaoguagua
 * @date 2020/9/12 02:19
 * 输入一个 非空 整型数组，数组里的数可能为正，也可能为负。
 * 数组中一个或连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 样例
 * 输入：[1, -2, 3, 10, -4, 7, 2, -5]
 * 输出：18
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]<=0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1]+nums[i];
            }

            max = Math.max(max,dp[i]);

        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(i);
    }
}
