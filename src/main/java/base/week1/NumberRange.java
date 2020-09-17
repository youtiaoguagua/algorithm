package base.week1;

import java.util.Scanner;

/**
 * 数的范围
 * @author youtiaoguagua
 * @date 2020/9/17 00:37
 * 给定一个按照升序排列的长度为n的整数数组，以及 q 个查询。
 * 对于每个查询，返回一个元素k的起始位置和终止位置（位置从0开始计数）。
 * 如果数组中不存在该元素，则返回“-1 -1”。
 * 输入格式
 * 第一行包含整数n和q，表示数组长度和询问个数。
 * 第二行包含n个整数（均在1~10000范围内），表示完整数组。
 * 接下来q行，每行包含一个整数k，表示一个询问元素。
 * 输出格式
 * 共q行，每行包含两个整数，表示所求元素的起始位置和终止位置。
 * 如果数组中不存在该元素，则返回“-1 -1”。
 * 数据范围
 * 1≤n≤100000
 * 1≤q≤10000
 * 1≤k≤10000
 * 输入样例：
 * 6 3
 * 1 2 2 3 3 4
 * 3
 * 4
 * 5
 * 输出样例：
 * 3 4
 * 5 5
 * -1 -1
 */
public class NumberRange {
    private static int[] nums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        nums = ints;
        int[] g = new int[t];
        for (int i = 0; i < t; i++) {
            int f = scanner.nextInt();
            search(f);
        }
    }

    public static void search(int target){
        int left = 0,right = nums.length;
        while (left<right){
            int mid = left+right>>1;
            if (nums[mid]>=target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if (left> nums.length-1||nums[left]!=target){
            System.out.println("-1 -1");
            return;
        }
        int tmp = left;
        left = 0;
        right= nums.length-1;
        while (left<right){
            int mid = left+right+1>>1;
          if (nums[mid]<=target){
              left = mid;
          }else {
              right = mid-1;
          }
        }
            System.out.println(tmp+" "+right);
    }
}
