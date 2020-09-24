package base.week3;

/**
 * 有向图的拓扑序列
 * @author youtiaoguagua
 * @date 2020/9/23 01:07
 * 给定一个n个点m条边的有向图，点的编号是1到n，图中可能存在重边和自环。
 * 请输出任意一个该有向图的拓扑序列，如果拓扑序列不存在，则输出-1。
 * 若一个由图中所有点构成的序列A满足：对于图中的每条边(x, y)，x在A中都出现在y之前，则称A是该图的一个拓扑序列。
 * 输入格式
 * 第一行包含两个整数n和m
 * 接下来m行，每行包含两个整数x和y，表示存在一条从点x到点y的有向边(x, y)。
 * 输出格式
 * 共一行，如果存在拓扑序列，则输出拓扑序列。
 * 否则输出-1。
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 3 3
 * 1 2
 * 2 3
 * 1 3
 * 输出样例：
 * 1 2 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class TopologicalSort {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int[] dp;
    static int[] queue;
    static int n;

    static void add(int a,int b){
        ArrayList<Integer> list = map.get(a);
        list.add(b);
    }

    static boolean bfs(){
        int hh = 0,tt=-1;
        for (int i = 1; i <= n; i++) {
            if (dp[i]==0){
                queue[++tt] = i;
            }
        }
        while (hh<=tt){
            int t = queue[hh++];
            ArrayList<Integer> list = map.get(t);
            for (Integer integer : list) {
                dp[integer]--;
                if (dp[integer]==0){
                    queue[++tt] = integer;
                }
            }
        }
        return tt==n-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        dp = new int[n+1];
        queue = new int[n+1];
        reader.lines().map(a->a.split(" ")).forEach(d->{
            int a = Integer.parseInt(d[0]);
            int b = Integer.parseInt(d[1]);
            add(a,b);
            dp[b]++;
        });

        if (bfs()){
            for (int i = 0; i < queue.length-1; i++) {
                System.out.printf("%d ",queue[i]);
            }
        }else {
            System.out.println("-1");
        }

    }
}
