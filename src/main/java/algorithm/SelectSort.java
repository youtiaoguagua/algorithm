package algorithm;

import java.util.Arrays;

public class SelectSort {

    public int[] sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<min){
                    min = nums[j];
                    minIndex = j;
                }
            }
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] sort = selectSort.sort(new int[]{5, 4, 3, 10, 2, 1,});
        String s = Arrays.toString(sort);
        System.out.println(s);

    }
}
