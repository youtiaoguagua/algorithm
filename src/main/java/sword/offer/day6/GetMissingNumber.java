package sword.offer.day6;

/**
 * 0到n-1中缺失的数字
 * @author youtiaoguagua
 * @date 2020/9/14 01:52
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
 * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 样例
 * 输入：[0,1,2,4]
 * 输出：3
 */
public class GetMissingNumber {
    /**
     * 长度为n-1，但是缺少一个数，因此原长度就是n-1+1；
     * 算出0到n的所有数的和，然后减去在0，n-1中的数，就会得到剩下的数；
     */
    public int getMissingNumber(int[] nums) {
        int n = nums.length+1;
        int j = (nums.length) * n / 2;
        for (int i = 0; i < nums.length; i++) {
            j-=nums[i];
        }
        return j;
    }
}
