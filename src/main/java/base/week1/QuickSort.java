package base.week1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序
 *
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
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] ints = new int[i];
        for (int j = 0; j < i; j++) {
            int t = scanner.nextInt();
            ints[j] = t;
        }
        //int[] ints = {49 ,59, 88 ,37 ,98, 97 ,68 ,54 ,1 ,3};
        sort(ints);
        Arrays.stream(ints).forEach((a) -> System.out.printf("%d ", a));
    }

    public static void sort(int n[]) {
        dfs(n, 0, n.length - 1);
    }

    public static void dfs(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l, right = r;

        int base = nums[l];
        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        int tmp2 = nums[l];
        nums[l] = nums[left];
        nums[left] = tmp2;
        dfs(nums, l, left - 1);
        dfs(nums, left + 1, r);
    }


    public static void sort2(int[] nums,int left,int right){
        if (left >= right) {
            return;
        }
        int l = left-1;
        int r = right +1;
        int key = nums[left];
        while (l<r){


            do {
                l++;
            }while (nums[l]<key);

            do {
                r--;
            }while (nums[r]>key);



            if (l<r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        sort2(nums,left,r);
        sort2(nums,r+1,right);
    }
}
