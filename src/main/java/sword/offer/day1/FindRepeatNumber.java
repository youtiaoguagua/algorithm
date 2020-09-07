package sword.offer.day1;


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
        int repeatNumber = findRepeatNumber.findRepeatNumber2(new int[]{52, 35, 51, 77, 19, 10, 27, 37, 54, 26, 75, 9, 71, 81, 76, 75, 21, 100, 54, 50, 87, 40, 21, 87, 18, 23, 58, 12, 17, 84, 11, 6, 91, 73, 57, 19, 85, 65, 36, 44, 40, 77, 33, 56, 27, 48, 77, 59, 8, 65, 77, 13, 9, 52, 53, 9, 77, 73, 85, 33, 31, 10, 84, 94, 4, 13, 82, 12, 91, 89, 93, 40, 42, -100, 85, 36, 20, 33, 13, 48, 38, 93, 30, 87, 47, 44, 29, 47, 33, 52, 36, 55, 20, 29, 68, 58, 64, 5, 15, 26});
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
        for (int num : nums) {
            if (num<0||num>nums.length-1){
                return -1;
            }
        }
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
