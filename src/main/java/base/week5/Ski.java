package base.week5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 滑雪
 * @author youtiaoguagua
 * @date 2020/9/29 17:59
 * 给定一个R行C列的矩阵，表示一个矩形网格滑雪场。
 * 矩阵中第 i 行第 j 列的点表示滑雪场的第 i 行第 j 列区域的高度。
 * 一个人从滑雪场中的某个区域内出发，每次可以向上下左右任意一个方向滑动一个单位距离。
 * 当然，一个人能够滑动到某相邻区域的前提是该区域的高度低于自己目前所在区域的高度。
 * 下面给出一个矩阵作为例子：
 *  1  2  3  4 5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 * 在给定矩阵中，一条可行的滑行轨迹为24-17-2-1。
 * 在给定矩阵中，最长的滑行轨迹为25-24-23-…-3-2-1，沿途共经过25个区域。
 * 现在给定你一个二维矩阵表示滑雪场各区域的高度，请你找出在该滑雪场中能够完成的最长滑雪轨迹，并输出其长度(可经过最大区域数)。
 * 输入格式
 * 第一行包含两个整数R和C。
 * 接下来R行，每行包含C个整数，表示完整的二维矩阵。
 * 输出格式
 * 输出一个整数，表示可完成的最长滑雪长度。
 * 数据范围
 * 1≤R,C≤300,
 * 0≤矩阵中整数≤10000
 * 输入样例：
 * 5 5
 * 1 2 3 4 5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 * 输出样例：
 * 25
 */
public class Ski {

    private static int n;
    private static int m;
    private static int[][] nums;
    private static int[][] f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        nums = new int[n][m];
        f = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }


        int res= 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        System.out.println(res);
    }

    private static int dfs(int a, int b) {
        if (f[a][b]!=-1){
            return f[a][b];
        }
        f[a][b] = 1;
        int[] x = {-1,0,1,0},y={0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            int ta = a + x[i], tb = b + y[i];
            if (ta >= 0 && ta < n && tb >= 0 && tb < m && nums[a][b] > nums[ta][tb]) {
                f[a][b] = Math.max( f[a][b],dfs(ta,tb)+1);
            }
        }
        return  f[a][b];
    }
}
