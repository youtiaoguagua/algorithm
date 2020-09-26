package base.week4;

import java.util.Scanner;

/**
 * 最大公约数
 * @author youtiaoguagua
 * @date 2020/9/26 02:45
 * 给定n对正整数ai,bi，请你求出每对数的最大公约数。
 *
 * 输入格式
 * 第一行包含整数n。
 *
 * 接下来n行，每行包含一个整数对ai,bi。
 *
 * 输出格式
 * 输出共n行，每行输出一个整数对的最大公约数。
 *
 * 数据范围
 * 1≤n≤105,
 * 1≤ai,bi≤2∗109
 * 输入样例：
 * 2
 * 3 6
 * 4 6
 * 输出样例：
 * 3
 * 2
 */
public class MaxCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int swap = swap(a, b);
            System.out.println(swap);
        }
    }

    private static int swap(int a, int b) {
        return b!=0?swap(b,(a%b)):a;
    }
}
