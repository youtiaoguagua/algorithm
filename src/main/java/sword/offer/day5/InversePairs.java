package sword.offer.day5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 数组中的逆序对
 * @author youtiaoguagua
 * @date 2020/9/13 22:02
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 样例
 * 输入：[1,2,3,4,5,6,0]
 * 输出：6
 */
public class InversePairs {

    private int[] nums;

    public int inversePairs2(int[] nums) {
        this.nums = nums;
        return mergeSort(0,nums.length-1);
    }

    private int mergeSort(int left, int right) {
        if (left>=right){
            return 0;
        }

        int mid = left+((right-left)>>1);
        int i = mergeSort(left, mid);
        int j = mergeSort(mid+1, right);
        int res = i+j;
        int l = left;
        int r = mid+1;
        ArrayList<Integer> list = new ArrayList<>();
        while (l<=mid&&r<=right){
            if (nums[l]<=nums[r]){
                list.add(nums[l++]);
            }else {
                list.add(nums[r++]);
                res+=mid-l+1;
            }
        }

        while (l<=mid){
            list.add(nums[l++]);
        }

        while (r <= right) {
            list.add(nums[r++]);
        }

        int n =0;
        for (int k = left; k <=right; k++) {
            nums[k] = list.get(n++);
        }

        return res;
    }


    /**
     * 时间复杂度极高
     */
    public int inversePairs(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]> nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        int[] ints = {1, 2, 3, 4, 5, 6, 0};
        int i = inversePairs.inversePairs2(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(i);
    }
}
