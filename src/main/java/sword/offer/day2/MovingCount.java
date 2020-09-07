package sword.offer.day2;

/**
 * @author youtiaoguagua
 * @date 2020/9/7 上午 11:00
 * 地上有一个  m  行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 请问该机器人能够达到多少个格子？
 * 样例1
 * 输入：k=7, m=4, n=5
 * 输出：20
 * 样例2
 * 输入：k=18, m=40, n=40
 * 输出：1484
 * 解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 */
public class MovingCount {

    private int maxCount=0;
    private int[][] nums;

    public int movingCount(int threshold, int rows, int cols) {
         this.nums = new int[rows][cols];
        dfs(0,0,threshold);
        return maxCount;
    }

    private void dfs( int x, int y,int threshold) {
        if (x<0||x>nums.length-1||y<0||y>nums[0].length-1||sum(x)+sum(y)>threshold){
            return;
        }
        if (nums[x][y]==1){
            return;
        }


        nums[x][y] = 1;
        maxCount+=1;

        int[] a = {-1,1,0,0}; int[] b = {0,0,-1,1};
        for (int i = 0; i < 4; i++) {
            dfs(x+a[i],y+b[i],threshold);
        }
    }

    private int sum(int num) {
        int tmp = 0;
        while (num>0){
            tmp += num % 10;
            num/=10;
        }
        return tmp;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        int i = movingCount.movingCount(7, 4, 5);
        System.out.println(i);
    }
}
