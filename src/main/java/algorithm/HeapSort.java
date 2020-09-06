package algorithm;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] sort = heapSort.sort(new int[]{4,6,8,5,9});
        String s = Arrays.toString(sort);
        System.out.println(s);
    }

    public int[] sort(int[] nums) {
        for (int i = nums.length/2-1; i >=0; i--) {
            getBigHeap(nums,i, nums.length);
        }
        //[9, 6, 8, 5, 4]
        System.out.println(Arrays.toString(nums));

        for (int i = nums.length-1; i >0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            getBigHeap(nums,0,i);
        }


        return nums;
    }


    /**
     * @param nums  数组
     * @param index 最后一个非叶子节点的索引
     * @param length 对0到length个元素进行调整，因为按照堆排序规则，
     *               会将最后的元素变成最大元素，因此每次调整堆时就需要减去这部分长度
     */
    public void getBigHeap(int[] nums, int index, int length) {
        int tmp = nums[index];

        for (int i = 2*index+1; i <length ; i=i*2+1) {
            if (i+1< length&&nums[i]<nums[i+1]){
                i++;
            }

            if (nums[i]>tmp){
                nums[index] = nums[i];
                index=i;
            }else {
                break;
            }
        }

        nums[index] = tmp;
    }
}
