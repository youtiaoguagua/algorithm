package algorithm;

import java.util.Arrays;

public class Bubble {

    public int[] bubble(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-i; j++) {
                if (nums[j]<nums[j-1]){
                    int t = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = t;
                }
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] bubble1 = bubble.bubble(new int[]{5, 4, 3, 10,2, 1,});
        String s = Arrays.toString(bubble1);
        System.out.println(s);
    }
}
