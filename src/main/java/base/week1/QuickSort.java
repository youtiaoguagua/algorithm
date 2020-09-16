package base.week1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序
 * @author youtiaoguagua
 * @date 2020/9/16 14:01
 * 给定你一个长度为n的整数数列。
 * 请你使用快速排序对这个数列按照从小到大进行排序。
 * 并将排好序的数列按顺序输出。
 * 输入格式
 * 输入共两行，第一行包含整数 n。
 * 第二行包含 n 个整数（所有整数均在1~109范围内），表示整个数列。
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 */
public class QuickSort {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int i = scanner.nextInt();
        //int[] ints = new int[i];
        //for (int j = 0; j < i; j++) {
        //    int t = scanner.nextInt();
        //    ints[j] = t;
        //}
        QuickSort quickSort = new QuickSort();
        int[] ints = {3, 1, 2, 4, 5};
        int[] sort = quickSort.sort(ints);
       Arrays.stream(sort).forEach((a)-> System.out.printf("%d ",a));
    }

    public int[] sort(int[] nums){
        dfs(nums,0,nums.length-1);
        return nums;
    }


    public void dfs(int[] nums, int l, int r){
        if (r<=0||l>= r){
            return;
        }
        int left = l+1,right=r;

        int base = nums[l];
        while (left<right){
            while (left< right&&nums[right]>base){
                right--;
            }

            while (left< right&&nums[left]<base){
                left++;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        if (nums[left]<base){
            nums[l] = nums[left];
            nums[left] = base;
        }
        dfs(nums,0,left-1);
        dfs(nums,left+1,r);
    }


}
