package base.week4;

import java.util.Scanner;

/**
 * 试除法判定质数
 * @author youtiaoguagua
 * @date 2020/9/25 12:25
 * 给定n个正整数ai，判定每个数是否是质数。
 * 输入格式
 * 第一行包含整数n。
 * 接下来n行，每行包含一个正整数ai。
 * 输出格式
 * 共n行，其中第 i 行输出第 i 个正整数ai是否为质数，是则输出“Yes”，否则输出“No”。
 * 数据范围
 * 1≤n≤100,
 * 1≤ai≤2∗109
 * 输入样例：
 * 2
 * 2
 * 6
 * 输出样例：
 * Yes
 * No
 */
public class DeterminePrimeNumbers {

    public static void judge(int n){
        if (n==1){
            System.out.println("No");
            return;
        }
        for (int i = 2; i <= n/i; i++) {
            if (n%i==0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            judge(t);
        }
    }
}
