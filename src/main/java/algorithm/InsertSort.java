package algorithm;

import java.util.Arrays;

public class InsertSort {

    public int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i-1;
            int value = nums[i];
            while (j>=0&&value<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = value;
        }

        return nums;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] sort = insertSort.sort(new int[]{5, 4, 3, 10, -1,2, 1,});
        String s = Arrays.toString(sort);
        System.out.println(s);
    }
}
