package base.week4;

import java.util.Scanner;

/**
 * 分解质因数
 * @author youtiaoguagua
 * @date 2020/9/25 22:11
 * 给定n个正整数ai，将每个数分解质因数，并按照质因数从小到大的顺序输出每个质因数的底数和指数。
 * 输入格式
 * 第一行包含整数n。
 * 接下来n行，每行包含一个正整数ai。
 * 输出格式
 * 对于每个正整数ai,按照从小到大的顺序输出其分解质因数后，每个质因数的底数和指数，每个底数和指数占一行。
 * 每个正整数的质因数全部输出完毕后，输出一个空行。
 * 数据范围
 * 1≤n≤100,
 * 1≤ai≤2∗109
 * 输入样例：
 * 2
 * 6
 * 8
 * 输出样例：
 * 2 1
 * 3 1
 *
 * 2 3
 */
public class DecomposePrimeFactors {
    public static void solve(int n) {
        for (int i = 2; i <= n/i; i++) {
            if (n % i == 0) {
                int s =0;
                while (n % i == 0) {
                    n = n/i;
                    s++;
                }
                System.out.println(i+" "+s);
            }
        }
        if (n>1){
            System.out.println(n+" "+1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            solve(t);
            System.out.println();
        }
    }
}
