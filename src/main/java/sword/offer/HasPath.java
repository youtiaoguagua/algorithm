package sword.offer;

/**
 *  矩阵中的路径
 * @author youtiaoguagua
 * @date 2020/9/7 上午 2:20
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 注意：
 * 输入的路径不为空；
 * 所有出现的字符均为大写英文字母；
 * 样例
 * matrix=[
 *   ["A","B","C","E"],
 *   ["S","F","C","S"],
 *   ["A","D","E","E"]]
 * str="BCCE" , return "true"
 * str="ASAE" , return "false"
 */
public class HasPath {
    public boolean hasPath(char[][] matrix, String str) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean dfs = dfs(matrix, str, 0, i, j);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] matrix, String str, int n, int x, int y){
        if (n==str.length()){
            return true;
        }

        if (matrix[x][y]!=str.charAt(n)){
            return false;
        }

        char tmp = matrix[x][y];
        matrix[x][y] = '*';

        if (x-1>0&& dfs(matrix,str,n+1,x-1,y)){
           return true;
        }
        if (x+1<matrix[0].length&& dfs(matrix,str,n+1,x+1,y)){
            return true;
        }

        if (y-1>0&& dfs(matrix,str,n+1,x,y-1)){
            return true;
        }

        if (y+1<matrix.length&& dfs(matrix,str,n+1,x,y+1)){
            return true;
        }

        matrix[x][y] = tmp;
        return false;
    }

    public static void main(String[] args) {
        HasPath hasPath = new HasPath();
        boolean bcce = hasPath.hasPath(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "BCCE");
        System.out.println(bcce);
    }

}
