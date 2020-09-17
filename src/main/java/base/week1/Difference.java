package base.week1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 差分
 * @author youtiaoguagua
 * @date 2020/9/17 15:19
 * 输入一个长度为n的整数序列。
 * 接下来输入m个操作，每个操作包含三个整数l, r, c，表示将序列中[l, r]之间的每个数加上c。
 * 请你输出进行完所有操作后的序列。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 第二行包含n个整数，表示整数序列。
 * 接下来m行，每行包含三个整数l，r，c，表示一个操作。
 * 输出格式
 * 共一行，包含n个整数，表示最终序列。
 * 数据范围
 * 1≤n,m≤100000,
 * 1≤l≤r≤n,
 * −1000≤c≤1000,
 * −1000≤整数序列中元素的值≤1000
 * 输入样例：
 * 6 3
 * 1 2 2 1 2 1
 * 1 3 1
 * 3 5 1
 * 1 6 1
 * 输出样例：
 * 3 4 5 3 4 2
 */
public class Difference {
    static int[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt()+1;
        int h = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 1; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        b = new int[n+1];

        for (int i = 1; i < n; i++) {
            different(i,i,nums[i]);
        }

        for (int i = 0; i < h; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            different(a,b,c);
        }
        for (int i = 1; i <n ; i++) {
            b[i] +=b[i-1];
            System.out.printf("%d ",b[i]);
        }
    }

    private static void different(int l, int r, int num) {
        b[l]+=num;
        b[r+1]-=num;
    }
}
