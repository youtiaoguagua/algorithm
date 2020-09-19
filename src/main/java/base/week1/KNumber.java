package base.week1;

import java.util.Scanner;

/**
 * 第k个数
 * @author youtiaoguagua
 * @date 2020/9/19 15:53
 * 给定一个长度为n的整数数列，以及一个整数k，请用快速选择算法求出数列的第k小的数是多少。
 * 输入格式
 * 第一行包含两个整数 n 和 k。
 * 第二行包含 n 个整数（所有整数均在1~109范围内），表示整数数列。
 * 输出格式
 * 输出一个整数，表示数列的第k小数。
 * 数据范围
 * 1≤n≤100000,
 * 1≤k≤n
 * 输入样例：
 * 5 3
 * 2 4 1 5 3
 * 输出样例：
 * 3
 */
public class KNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int res = search(nums,0,nums.length-1,target);
        System.out.println(res);
    }

    private static int search(int[] nums, int left, int right,int target) {
        if (left==right){
            return nums[left];
        }

        int l = left-1;
        int r = right+1;
        int x = nums[left];
        while (l<r){
            while (nums[++l]<x){
            }

            while (nums[--r]>x){
            }

            if (l<r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }

        int len = r-left+1;
        if (len>=target){
            return search(nums,left,r,target);
        }else {
            return search(nums,r+1,right,target-len);
        }

    }
}
