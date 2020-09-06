package algorithm;

import java.util.Arrays;

public class HillSort {

    public static void main(String[] args) {
        HillSort hillSort = new HillSort();
        int[] sort = hillSort.sort(new int[]{5, 4, 3, 10, -1,2, 1});
        String s = Arrays.toString(sort);
        System.out.println(s);
    }

    private int[] sort(int[] nums) {
        dfs(nums,nums.length);
        return nums;
    }

    public void dfs(int[] nums,int gap){
        int group = gap / 2;
        if (group == 0) {
            return;
        }
        for (int i = group; i < nums.length; i++) {
            int j =i;
            int tmp = nums[j];
            while (j - group >= 0 && tmp < nums[j - group]) {
                nums[j] = nums[j-group];
                j-=group;
            }

            nums[j] = tmp;
        }
        dfs(nums,group);
    }
}
