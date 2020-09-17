package base.week1;

import java.util.Scanner;

/**
 * 前缀和
 * @author youtiaoguagua
 * @date 2020/9/17 12:31
 * 输入一个长度为n的整数序列。
 * 接下来再输入m个询问，每个询问输入一对l, r。
 * 对于每个询问，输出原序列中从第l个数到第r个数的和。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 第二行包含n个整数，表示整数数列。
 * 接下来m行，每行包含两个整数l和r，表示一个询问的区间范围。
 * 输出格式
 * 共m行，每行输出一个询问的结果。
 * 数据范围
 * 1≤l≤r≤n,
 * 1≤n,m≤100000,
 * −1000≤数列中元素的值≤1000
 * 输入样例：
 * 5 3
 * 2 1 3 6 4
 * 1 2
 * 1 3
 * 2 4
 * 输出样例：
 * 3
 * 6
 * 10
 */
public class PrefixSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = scanner.nextInt();
        int[] ints = new int[n];
        int[] z = new int[n+1];
        for (int i1 = 0; i1 < n; i1++) {
            ints[i1] = scanner.nextInt();
        }

        for (int y = 1; y < z.length; y++) {
            z[y] = z[y-1]+ints[y-1];
        }

        for (int j = 0; j < i; j++) {
            int one = scanner.nextInt();
            int two = scanner.nextInt();
            prefixSum(z,one,two);
        }
    }

    public static void prefixSum(int[] ints, int one, int two){
        int res = ints[two]-ints[one-1];
        System.out.println(res);
    }
}
