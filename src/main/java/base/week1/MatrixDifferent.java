package base.week1;

import java.io.*;
import java.util.Scanner;

/**
 * 差分矩阵
 * @author youtiaoguagua
 * @date 2020/9/17 18:46
 * 输入一个n行m列的整数矩阵，再输入q个操作，每个操作包含五个整数x1, y1, x2, y2, c，其中(x1, y1)和(x2, y2)表示一个子矩阵的左上角坐标和右下角坐标。
 * 每个操作都要将选中的子矩阵中的每个元素的值加上c。
 * 请你将进行完所有操作后的矩阵输出。
 * 输入格式
 * 第一行包含整数n,m,q。
 * 接下来n行，每行包含m个整数，表示整数矩阵。
 * 接下来q行，每行包含5个整数x1, y1, x2, y2, c，表示一个操作。
 * 输出格式
 * 共 n 行，每行 m 个整数，表示所有操作进行完毕后的最终矩阵。
 * 数据范围
 * 1≤n,m≤1000,
 * 1≤q≤100000,
 * 1≤x1≤x2≤n,
 * 1≤y1≤y2≤m,
 * −1000≤c≤1000,
 * −1000≤矩阵内元素的值≤1000
 * 输入样例：
 * 3 4 3
 * 1 2 2 1
 * 3 2 2 1
 * 1 1 1 1
 * 1 1 2 2 1
 * 1 3 2 3 2
 * 3 1 3 4 1
 * 输出样例：
 * 2 3 4 1
 * 4 3 4 1
 * 2 2 2 2
 */
public class MatrixDifferent {
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        String[] s1 = s.split(" ");
        //Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int q = Integer.parseInt(s1[2]);
        int[][] nums = new int[n+1][m+1];
        d = new int[n+2][m+2];
        for (int i = 1; i <= n; i++) {
            s = reader.readLine();
           s1 = s.split(" ");
            for (int j = 1; j <= m; j++) {
                nums[i][j] = Integer.parseInt(s1[j-1]);
                matrixDifferent(i,j,i,j,nums[i][j]);
            }
        }

        for (int i = 0; i < q; i++) {

            int[] tmp = new int[5];
            s = reader.readLine();
            s1 = s.split(" ");
            for (int j = 0; j < 5; j++) {
                tmp[j] = Integer.parseInt(s1[j]);
            }
            matrixDifferent(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4]);
        }


        for (int i =1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                d[i][j] = d[i-1][j]+d[i][j-1]-d[i-1][j-1]+d[i][j];
                writer.write(d[i][j]+" ");
            }
            writer.write("\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }


    private static void matrixDifferent(int x1, int y1, int x2, int y2, int c) {
        d[x1][y1]+=c;
        d[x2+1][y1]-=c;
        d[x1][y2+1]-=c;
        d[x2+1][y2+1]+=c;
    }
}
