package sword.offer.day3;

import java.util.Arrays;

/**
 * 顺时针打印矩阵
 * @author youtiaoguagua
 * @date 2020/9/9 21:08
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 样例
 * 输入：
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class PrintMatrix {
    private int[][] matrix;
    int[] res;
    int index = 0;
    int row = 0;
    int col = 0;
    int type = 1;

    public int[] printMatrix(int[][] matrix) {
        if (matrix.length==0){
            return new int[]{};
        }
        this.matrix = matrix;
        this.res = new int[matrix.length * matrix[0].length];
        dfs();
        return res;
    }

    int[] left = {-1,0,1,0} ,right = {0,1,0,-1};
    int x=0,y=0;

    private void dfs() {
        if (index==res.length){
            return;
        }
        if (x<0||x>matrix.length-1||y<0||y> matrix[0].length-1){
            type = (type+1)%4;
            x = row+left[type];
            y = col+right[type];
        }
        if (matrix[x][y]==-1){
            type = (type+1)%4;
            x = row+left[type];
            y = col+right[type];
        }
        row = x;
        col = y;
        res[index] = matrix[row][col];
        index++;
        matrix[row][col] = -1;

        x = row+left[type];
        y = col+right[type];
        dfs();
    }

    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] a={{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        int[] ints = printMatrix.printMatrix(a);
        System.out.println(Arrays.toString(ints));
    }
}
