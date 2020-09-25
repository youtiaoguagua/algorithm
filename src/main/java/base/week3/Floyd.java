package base.week3;

import java.util.Scanner;

/**
 * Floyd求最短路
 * @author youtiaoguagua
 * @date 2020/9/24 20:43
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环，边权可能为负数。
 * 再给定k个询问，每个询问包含两个整数x和y，表示查询从点x到点y的最短距离，如果路径不存在，则输出“impossible”。
 * 数据保证图中不存在负权回路。
 * 输入格式
 * 第一行包含三个整数n，m，k
 * 接下来m行，每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。
 * 接下来k行，每行包含两个整数x，y，表示询问点x到点y的最短距离。
 * 输出格式
 * 共k行，每行输出一个整数，表示询问的结果，若询问两点间不存在路径，则输出“impossible”。
 * 数据范围
 * 1≤n≤200,
 * 1≤k≤n2
 * 1≤m≤20000,
 * 图中涉及边长绝对值均不超过10000。
 * 输入样例：
 * 3 3 2
 * 1 2 1
 * 2 3 2
 * 1 3 1
 * 2 1
 * 1 3
 * 输出样例：
 * impossible
 * 1
 */
public class Floyd {
    static int[][] nums;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        nums= new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=n ; j++) {
                if (i==j){
                    nums[i][j] = 0;
                }else {
                    nums[i][j] = (int)1e9;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            nums[a][b] = Math.min(nums[a][b],c);
        }
        floyd();
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int t = nums[a][b];
            if (t>=((int)1e9/2)){
                System.out.println("impossible");
            }else {
                System.out.println(t);
            }
        }
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    nums[i][j] = Math.min(nums[i][j], nums[i][k] + nums[k][j]);
                }
            }
        }
    }
}
