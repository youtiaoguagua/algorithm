package base.week1;

import java.util.Scanner;

/**
 * 数组元素的目标和
 * @author youtiaoguagua
 * @date 2020/9/19 13:35
 * 给定两个升序排序的有序数组A和B，以及一个目标值x。数组下标从0开始。
 * 请你求出满足A[i] + B[j] = x的数对(i, j)。
 * 数据保证有唯一解。
 * 输入格式
 * 第一行包含三个整数n，m，x，分别表示A的长度，B的长度以及目标值x。
 * 第二行包含n个整数，表示数组A。
 * 第三行包含m个整数，表示数组B。
 * 输出格式
 * 共一行，包含两个整数 i 和 j。
 * 数据范围
 * 数组长度不超过100000。
 * 同一数组内元素各不相同。
 * 1≤数组元素≤109
 * 输入样例：
 * 4 5 6
 * 1 2 4 7
 * 3 4 6 8 9
 * 输出样例：
 * 1 1
 */
public class ArrayTargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int target = scanner.nextInt();
        int[] nums = new int[a];
        int[] ints = new int[b];
        for (int i = 0; i < a; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < b; i++) {
            ints[i] = scanner.nextInt();
        }
        arrayTargetSum(target,nums,ints);
    }

    public static void arrayTargetSum(int target, int[] nums, int[] ints){
        for (int i = 0,j=ints.length-1; i < nums.length ; i++) {
            while (j>=0&&nums[i]+ints[j]>target){
                j--;
            }
            if (j>=0&&nums[i]+ints[j]==target){
                System.out.println(i+" "+j);
                break;
            }
        }
    }
}
