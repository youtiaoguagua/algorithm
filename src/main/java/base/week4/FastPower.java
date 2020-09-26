package base.week4;

import java.util.Scanner;

/**
 * 快速幂
 * @author youtiaoguagua
 * @date 2020/9/26 14:37
 * 给定n组ai,bi,pi，对于每组数据，求出abii mod pi的值。
 * 输入格式
 * 第一行包含整数n。
 * 接下来n行，每行包含三个整数ai,bi,pi。
 * 输出格式
 * 对于每组数据，输出一个结果，表示abii mod pi的值。
 * 每个结果占一行。
 * 数据范围
 * 1≤n≤100000,
 * 1≤ai,bi,pi≤2∗109
 * 输入样例：
 * 2
 * 3 2 5
 * 4 3 9
 * 输出样例：
 * 4
 * 1
 */
public class FastPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            fastPower(a, b, p);
        }
    }

    private static void fastPower(long a, int b, int p) {
        long res =1%p;
        while (b!=0) {
            if ((b&1)==1){
                res = res*a%p;
            }
            a = a*a%p;
            b = b>>1;
        }
        System.out.println(res);
    }
}
