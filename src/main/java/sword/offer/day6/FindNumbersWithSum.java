package sword.offer.day6;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 和为S的两个数字
 * @author youtiaoguagua
 * @date 2020/9/14 19:52
 * 输入一个数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，输出任意一对即可。
 * 你可以认为每组输入中都至少含有一组满足条件的输出。
 * 样例
 * 输入：[1,2,3,4] , sum=7
 * 输出：[3,4]
 */
public class FindNumbersWithSum {

    public int[] findNumbersWithSum2(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target-nums[i])){
                return new int[]{nums[i], target - nums[i]};
            }
            set.add(nums[i]);
        }
        return new int[]{};
    }

    public int[] findNumbersWithSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int find = target-nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]==find){
                    return new int[]{nums[i],find};
                }
            }
        }
        return new int[]{};
    }
}
