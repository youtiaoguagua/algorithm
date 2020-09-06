package algorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(new int[]{5, 4, 3, 10, -1, 2, 1});
        String s = Arrays.toString(sort);
        System.out.println(s);
    }

    private int[] sort(int[] nums) {
        dfs(nums, 0, nums.length - 1);
        return nums;
    }

    private void dfs(int[] nums, int startIndex, int endIndex) {
        if (endIndex<=0||startIndex>=endIndex){
            return;
        }

        int start = startIndex+1;
        int end = endIndex;
        int baseNum = nums[startIndex];

        while (end > start) {
            while (end > start && nums[end] > baseNum) {
                end--;
            }

            while (end > start && nums[start] < baseNum) {
                start++;
            }

            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
        }

        nums[startIndex] = nums[start];
        nums[start] = baseNum;

        dfs(nums,0,start-1);
        dfs(nums,end+1,endIndex);
    }
}
