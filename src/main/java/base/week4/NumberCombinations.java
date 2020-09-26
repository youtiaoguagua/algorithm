package base.week4;

import java.util.Scanner;

/**
 *求组合数 I
 * @author youtiaoguagua
 * @date 2020/9/26 17:07
 * 给定n组询问，每组询问给定两个整数a，b，请你输出Cba mod (109+7)的值。
 * 输入格式
 * 第一行包含整数n。
 * 接下来n行，每行包含一组a和b。
 * 输出格式
 * 共n行，每行输出一个询问的解。
 * 数据范围
 * 1≤n≤10000,
 * 1≤b≤a≤2000
 * 输入样例：
 * 3
 * 3 1
 * 5 3
 * 2 2
 * 输出样例：
 * 3
 * 10
 * 1
 */
public class NumberCombinations {
    static int N = 2010;
    static int[][] tb = new int[N+1][N+1];
    static int mod = (int) 1e9+7;
    
    public static void numberCombinations(){
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (j==1){
                    tb[i][j] = 1;
                }else {
                    tb[i][j] = (tb[i-1][j] + tb[i-1][j-1])%mod;
                }
            }
        }
    }

    public static void main(String[] args) {
        numberCombinations();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(tb[a+1][b+1]);
        }
    }
}
