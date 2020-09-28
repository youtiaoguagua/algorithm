package base.week5;

import java.util.Scanner;

/**
 * 数字三角形
 * @author youtiaoguagua
 * @date 2020/9/27 11:09
 * 给定一个如下图所示的数字三角形，从顶部出发，在每一结点可以选择移动至其左下方的结点或移动至其右下方的结点，一直走到底层，要求找出一条路径，使路径上的数字的和最大。
 *         7
 *       3   8
 *     8   1   0
 *   2   7   4   4
 * 4   5   2   6   5
 * 输入格式
 * 第一行包含整数n，表示数字三角形的层数。
 * 接下来n行，每行包含若干整数，其中第 i 行表示数字三角形第 i 层包含的整数。
 * 输出格式
 * 输出一个整数，表示最大的路径数字和。
 * 数据范围
 * 1≤n≤500,
 * −10000≤三角形中的整数≤10000
 * 输入样例：
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * 输出样例：
 * 30
 */
public class NumTriangle {
    static int n;
    static int N =510;
    static int[][] nums = new int[N][N],dp= new int[N][N];

    public static void numTriangle(){
        for (int i = n-1; i >0; i--) {
            for (int j = 1; j <=i ; j++) {
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1])+nums[i][j];
            }
        }
        System.out.println(dp[1][1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i+1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                int t = scanner.nextInt();
                nums[i][j] = t;
                if (i==n){
                    dp[i][j] = t;
                }
            }
        }

        numTriangle();
    }
}
