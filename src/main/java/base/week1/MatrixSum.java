package base.week1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 子矩阵的和
 * @author youtiaoguagua
 * @date 2020/9/17 13:47
 * 输入一个n行m列的整数矩阵，再输入q个询问，每个询问包含四个整数x1, y1, x2, y2，表示一个子矩阵的左上角坐标和右下角坐标。
 * 对于每个询问输出子矩阵中所有数的和。
 * 输入格式
 * 第一行包含三个整数n，m，q。
 * 接下来n行，每行包含m个整数，表示整数矩阵。
 * 接下来q行，每行包含四个整数x1, y1, x2, y2，表示一组询问。
 * 输出格式
 * 共q行，每行输出一个询问的结果。
 * 数据范围
 * 1≤n,m≤1000,
 * 1≤q≤200000,
 * 1≤x1≤x2≤n,
 * 1≤y1≤y2≤m,
 * −1000≤矩阵内元素的值≤1000
 * 输入样例：
 * 3 4 3
 * 1 7 2 4
 * 3 6 2 8
 * 2 1 2 3
 * 1 1 2 2
 * 2 1 3 4
 * 1 3 3 4
 * 输出样例：
 * 17
 * 27
 * 21
 */
public class MatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] t = new int[3];
        for (int i = 0; i < 3; i++) {
            t[i] = scanner.nextInt();
        }

        int[][] nums = new int[t[0]][t[1]];
        int[][] s = new int[t[0]+1][t[1]+1];
        for (int i = 0; i < t[0]; i++) {
            for (int j = 0; j < t[1]; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i <= t[0]; i++) {
            for (int j = 1; j <= t[1]; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + nums[i-1][j-1];
            }
        }

        for (int i = 0; i < t[2]; i++) {
            int[] tmp = new int[4];
            for (int j = 0; j < 4; j++) {
                tmp[j] = scanner.nextInt();
            }
            matrixSum(s,tmp);
        }

    }

    private static void matrixSum(int[][] s, int[] tmp) {
        int res = s[tmp[2]][tmp[3]]-s[tmp[0]-1][tmp[3]]-s[tmp[2]][tmp[1]-1]+s[tmp[0]-1][tmp[1]-1];
        System.out.println(res);
    }
}
