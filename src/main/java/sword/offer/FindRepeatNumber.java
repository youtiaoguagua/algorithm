package sword.offer;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3 
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int repeatNumber = findRepeatNumber.findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(repeatNumber);
    }

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            boolean add = integers.add(num);
            if (!add){
                return num;
            }
        }
        return -1;
    }


    /**
     * 优化版
     * 0, 1, 2, 3, 4, 5, 6
     * 2, 3, 1, 0, 2, 5, 3
     */
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0||nums[i]>nums.length-1){
                return -1;
            }

            if (nums[i]!=i&&nums[nums[i]]==nums[i]){
                return nums[i];
            }

            while (nums[i]!=i&&nums[nums[i]]!=nums[i]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

}
