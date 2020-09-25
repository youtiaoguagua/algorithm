package base.week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 染色法判定二分图
 * @author youtiaoguagua
 * @date 2020/9/25 01:42
 * 给定一个n个点m条边的无向图，图中可能存在重边和自环。
 * 请你判断这个图是否是二分图。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 接下来m行，每行包含两个整数u和v，表示点u和点v之间存在一条边。
 * 输出格式
 * 如果给定图是二分图，则输出“Yes”，否则输出“No”。
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 4
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 输出样例：
 * Yes
 */
public class DyeingBinaryPicture {
    static int n, m,index=0;
    static int[] e,ne,h,color;

    public static void add(int a,int b){
        e[index] = b;
        ne[index] = h[a];
        h[a] = index++;
    }

    public static boolean dfs(int u, int col){
        color[u] = col;
        for (int i = h[u]; i !=-1 ; i=ne[i]) {
            int t = e[i];
            if (color[t]==0){
                if (!dfs(t,3-col)){
                    return false;
                }
            }else if (color[t]==col){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        e = new int[2*m];
        ne = e.clone();
        h = new int[n+1];
        Arrays.fill(h,-1);
        color = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a,b);
            add(b,a);
        }

        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (color[i]==0){
                if (!dfs(i,1)){
                    flag = false;
                    break;
                }
            }
        }
        if (!flag){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }
    }
}
