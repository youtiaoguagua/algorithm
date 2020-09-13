package sword.offer.day5;

import java.util.Arrays;
import java.util.Collections;

/**
 * 数字在排序数组中出现的次数
 * @author youtiaoguagua
 * @date 2020/9/14 00:51
 * 统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组[1, 2, 3, 3, 3, 3, 4, 5]和数字3，由于3在这个数组中出现了4次，因此输出4。
 * 样例
 * 输入：[1, 2, 3, 3, 3, 3, 4, 5] ,  3
 * 输出：4
 */
public class GetNumberOfK {

    public int getNumberOfK2(int[] nums, int k) {
        if (nums.length==0){
            return 0;
        }
        int i=0;
        int j = nums.length-1;
        while (i<j){
            int mid = i+j>>1;
            if (nums[mid]<k){
                i = mid+1;
            }else {
                j = mid;
            }
        }
        if (nums[j]!=k){
            return 0;
        }
        int left = i;
        i =0;
        j=nums.length-1;
        while (i<j){
            int mid = i+j+1>>1;
            if (nums[mid]<=k){
                i = mid;
            }else {
                j = mid-1;
            }
        }

        return j-left+1;
    }

    public int getNumberOfK(int[] nums, int k) {
        long count = Arrays.stream(nums).filter(a -> a == k).count();
        return (int) count;
    }
}
