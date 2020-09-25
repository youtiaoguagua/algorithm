package base.week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Kruskal算法求最小生成树
 * @author youtiaoguagua
 * @date 2020/9/25 00:44
 * 给定一个n个点m条边的无向图，图中可能存在重边和自环，边权可能为负数。
 * 求最小生成树的树边权重之和，如果最小生成树不存在则输出impossible。
 * 给定一张边带权的无向图G=(V, E)，其中V表示图中点的集合，E表示图中边的集合，n=|V|，m=|E|。
 * 由V中的全部n个顶点和E中n-1条边构成的无向连通子图被称为G的一棵生成树，其中边的权值之和最小的生成树被称为无向图G的最小生成树。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 接下来m行，每行包含三个整数u，v，w，表示点u和点v之间存在一条权值为w的边。
 * 输出格式
 * 共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出impossible。
 * 数据范围
 * 1≤n≤105,
 * 1≤m≤2∗105,
 * 图中涉及边的边权的绝对值均不超过1000。
 * 输入样例：
 * 4 5
 * 1 2 1
 * 1 3 2
 * 1 4 3
 * 2 3 2
 * 3 4 4
 * 输出样例：
 * 6
 */
public class Kruskal {
    static ThreeData[] data;
    static int n,m;
    static int[] p;

    public static void kruskal(){
        Arrays.sort(data,(a,b)->a.c-b.c);
        int res=0,cnt=0;
        for (int i = 0; i < m; i++) {
            int a = data[i].a,b=data[i].b,c= data[i].c;
            a = find(a);
            b = find(b);
            if (a!=b){
                p[a] = b;
                res+=c;
                cnt++;
            }
        }
        if (cnt<n-1){
            System.out.println("impossible");
        }else {
            System.out.println(res);
        }
    }

    private static int find(int x) {
        if (p[x]!=x){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        data = new ThreeData[m];
        p = new int[n+1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            data[i] = new ThreeData(a, b, c);
        }
        kruskal();

    }


    static public class ThreeData{
        int a,b,c;

        public ThreeData(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
