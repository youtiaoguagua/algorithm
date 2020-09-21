package base.week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 堆排序
 * @author youtiaoguagua
 * @date 2020/9/21 13:17
 * 输入一个长度为n的整数数列，从小到大输出前m小的数。
 * 输入格式
 * 第一行包含整数n和m。
 * 第二行包含n个整数，表示整数数列。
 * 输出格式
 * 共一行，包含m个整数，表示整数数列中前m小的数。
 * 数据范围
 * 1≤m≤n≤105，
 * 1≤数列中元素≤109
 * 输入样例：
 * 5 3
 * 4 5 1 3 2
 * 输出样例：
 * 1 2 3
 */
public class HeapSort {
    static int[] nums;
    static int size;

    public static void down(int u){
        int tmp = u;
        if (u*2+1<=size&&nums[u*2+1]>nums[tmp]){
            tmp = u*2+1;
        }

        if (u*2+2<=size&&nums[u*2+2]>nums[tmp]){
            tmp = u*2+2;
        }

        if (u!=tmp){
            int t = nums[u];
            nums[u] = nums[tmp];
            nums[tmp] = t;
            down(tmp);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        size = n-1;
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = n-1; i >= 0; i--) {
            down(i);
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < n; i++) {
            int tmp = nums[0];
            nums[0] = nums[size];
            size--;
            down(0);
            nums[size+1] = tmp;
        }

        for (int i = 0; i < m; i++) {
            System.out.printf("%d ",nums[i]);
        }
    }
}
