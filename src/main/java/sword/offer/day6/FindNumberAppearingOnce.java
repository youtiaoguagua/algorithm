package sword.offer.day6;

/**
 * 数组中唯一只出现一次的数字
 * @author youtiaoguagua
 * @date 2020/9/14 19:19
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 * 你可以假设满足条件的数字一定存在。
 * 思考题：
 * 如果要求只使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？
 * 样例
 * 输入：[1,1,1,2,2,2,3,4,4,4]
 * 输出：3
 */
public class FindNumberAppearingOnce {

    /**
     * 宇宙级优化
     */
    public int findNumberAppearingOnce(int[] nums) {
        int one =0;
        int two =0;
        for (int num : nums) {
            one = (one^num)&~two;
            two = (two^num)&~one;
        }
        return one;
    }

    public int findNumberAppearingOnce2(int[] nums) {
        int[] ints = new int[32];
        for (int i = 0; i < nums.length; i++) {
            //int k =0;
            for (int j = 31,k=0; j >=0; j--,k++) {
                if ((nums[i]&(1<<k))==1){
                    ints[j]+=1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < ints.length; i++) {
            res=res<<1;
            res+=ints[i]%3;
        }
        return res;
    }

    public static void main(String[] args) {
        FindNumberAppearingOnce findNumberAppearingOnce = new FindNumberAppearingOnce();
        findNumberAppearingOnce.findNumberAppearingOnce(new int[]{1,1,1,2,2,2,3,4,4,4});
    }
}
