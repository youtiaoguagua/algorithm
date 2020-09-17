package base.week1;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author youtiaoguagua
 * @date 2020/9/16 20:20
 */
public class MergeSort {

    public static void mergeSort(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        int[] tmp = new int[right - left + 1];
        int mid = left+right>>1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        int k = 0, l = left,r = mid+1;
        while (l<=mid&&r<=right){
            if (nums[l]<=nums[r]){
                tmp[k++] = nums[l++];
            }else {
                tmp[k++] = nums[r++];
            }
        }
        while (l<=mid){
            tmp[k++] = nums[l++];
        }

        while (r <= right) {
            tmp[k++] = nums[r++];
        }
        for (int i = left,z=0; i <=right ; i++,z++) {
            nums[i] = tmp[z];
        }
    }

    public static void sort(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        //int[] ints = new int[]{5,4,3,2,1};

        sort(ints);
        Arrays.stream(ints).forEach(a-> System.out.printf("%d ",a));
    }
}
