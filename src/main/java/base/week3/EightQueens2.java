package base.week3;
/**
 * n-皇后问题
 * @author youtiaoguagua
 * @date 2020/9/22 18:38
 * n-皇后问题是指将 n 个皇后放在 n∗n 的国际象棋棋盘上，使得皇后不能相互攻击到，即任意两个皇后都不能处于同一行、同一列或同一斜线上。
 * 现在给定整数n，请你输出所有的满足条件的棋子摆法。
 * 数据范围
 * 1≤n≤9
 * 输入样例：
 * 4
 * 输出样例：
 * .Q..
 * ...Q
 * Q...
 * ..Q.
 *
 * ..Q.
 * Q...
 * ...Q
 * .Q..
 */
import java.util.Arrays;
import java.util.Scanner;

public class EightQueens2 {
    private static char[][] res;
    private static boolean[] cols;
    private static boolean[] rows;
    private static boolean[] lhy;
    private static boolean[] rhy;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        res = new char[n][n];
        cols = new boolean[n];
        rows = new boolean[n];
        lhy = new boolean[2 * n];
        rhy = new boolean[2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i],'.');
        }
        dfs(0,0,0);
    }

    private static void dfs(int row,int col,int count) {
        if (col==n){
            col=0;
            row++;
        }
        if (row==n){
            if (count==n){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (n==1){
                            System.out.printf("%c",res[i][j]);
                        }else {
                            System.out.printf("%c",res[i][j]);
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }
        dfs(row,col+1,count);
        if (!rows[row]&&!cols[col]&&!rhy[row+col]&&!lhy[n+row-col]){
            res[row][col] = 'Q';
            rows[row]=cols[col]=rhy[row+col]=lhy[n+row-col] = true;
            dfs(row,col+1,count+1);
            rows[row]=cols[col]=rhy[row+col]=lhy[n+row-col] = false;
            res[row][col] = '.';
        }
    }
}
