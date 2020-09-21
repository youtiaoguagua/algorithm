package base.week2;



/**
 * 连通块中点的数量
 * @author youtiaoguagua
 * @date 2020/9/21 13:19
 * 给定一个包含n个点（编号为1~n）的无向图，初始时图中没有边。
 * 现在要进行m个操作，操作共有三种：
 * “C a b”，在点a和点b之间连一条边，a和b可能相等；
 * “Q1 a b”，询问点a和点b是否在同一个连通块中，a和b可能相等；
 * “Q2 a”，询问点a所在连通块中点的数量；
 * 输入格式
 * 第一行输入整数n和m。
 * 接下来m行，每行包含一个操作指令，指令为“C a b”，“Q1 a b”或“Q2 a”中的一种。
 * 输出格式
 * 对于每个询问指令”Q1 a b”，如果a和b在同一个连通块中，则输出“Yes”，否则输出“No”。
 * 对于每个询问指令“Q2 a”，输出一个整数表示点a所在连通块中点的数量
 * 每个结果占一行。
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 5 5
 * C 1 2
 * Q1 1 2
 * Q2 1
 * C 2 5
 * Q2 5
 * 输出样例：
 * Yes
 * 2
 * 3
 */
import java.util.Arrays;
import java.util.Scanner;
public class PointInBlock {

    private static int[] p;
    private static int[] f;

    private static int find(int x) {
        if (p[x]!=x){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        p = new int[n + 1];
        f = new int[n + 1];
        Arrays.fill(f,1);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String next = scanner.next();
            if (next.equals("C")){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a!=b){
                    if (find(a)!=find(b)){

                    f[find(b)] += f[find(a)];
                    }
                    p[find(a)] = find(b);
                }

            }else if (next.equals("Q1")){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (find(a)==find(b)){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }else {
                int a = scanner.nextInt();
                System.out.println(f[find(a)]);
            }
        }
    }
}
