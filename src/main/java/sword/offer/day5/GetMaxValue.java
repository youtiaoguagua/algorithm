package sword.offer.day5;

/**
 * 礼物的最大价值
 * @author youtiaoguagua
 * @date 2020/9/13 14:35
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 * 注意：
 * m,n>0
 * 样例：
 * 输入：
 * [
 *   [2,3,1],
 *   [1,7,1],
 *   [4,6,1]
 * ]
 *
 * 输出：19
 *
 * 解释：沿着路径 2→3→7→6→1 可以得到拿到最大价值礼物。
 */
public class GetMaxValue {

    private int[][] grid;
    int[][] nums;


    public int getMaxValue(int[][] grid) {
        this.grid = grid;
        this.nums = new int[grid.length][grid[0].length];
        int dfs = dfs(0, 0);
        return dfs;
    }

    private int dfs(int x, int y) {
        if (x > grid.length - 1 || y > grid[0].length-1) {
            return 0;
        }
        if (nums[x][y]!=0){
            return nums[x][y];
        }

        int t = dfs(x + 1, y);
        int z = dfs(x, y + 1);
        int max = Math.max(t,z);
        int i = max + grid[x][y];
        nums[x][y] = i;
        return i;
    }

    public int getMaxValue2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }


    /**
     * 优化
     */
    public int getMaxValue3(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j])+grid[i][j];
            }
        }
        return dp[grid.length][grid[0].length];
    }


    /**
     * 再优化
     */
    public int getMaxValue4(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for (int i = 1; i < grid.length+1; i++) {
            for (int j = 1; j < grid[0].length+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }

    public static void main(String[] args) {
        GetMaxValue getMaxValue = new GetMaxValue();
        int[][] a = {{2,3,1},{1,7,1},{4,6,1}};
        int maxValue = getMaxValue.getMaxValue(a);
        System.out.println(maxValue);
    }

}
