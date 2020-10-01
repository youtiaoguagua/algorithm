package base.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 区间分组
 * @author youtiaoguagua
 * @date 2020/9/30 00:55
 * 给定N个闭区间[ai,bi]，请你将这些区间分成若干组，使得每组内部的区间两两之间（包括端点）没有交集，并使得组数尽可能小。
 * 输出最小组数。
 * 输入格式
 * 第一行包含整数N，表示区间数。
 * 接下来N行，每行包含两个整数ai,bi，表示一个区间的两个端点。
 * 输出格式
 * 输出一个整数，表示最小组数。
 * 数据范围
 * 1≤N≤105,
 * −109≤ai≤bi≤109
 * 输入样例：
 * 3
 * -1 1
 * 2 4
 * 3 5
 * 输出样例：
 * 2
 */
public class IntervalGrouping {

    private static int n;
    private static Range[] ranges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ranges[i] = new Range(a,b);
        }
        Arrays.sort(ranges, (a, b) -> a.left - b.left);
        solve2();
    }


    private static void solve2(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()||queue.peek()>=ranges[i].left){
                queue.add(ranges[i].right);
            }else{
                queue.poll();
                queue.add(ranges[i].right);
            }
        }
        System.out.println(queue.size());
    }

    private static void solve() {
        int[] list = new int[n];
        int res = 1;
        list[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < res; j++) {
               if (ranges[i].left>list[j]){
                   list[j] = ranges[i].right;
                   flag = true;
                   break;
               }
            }
            if (!flag){
                list[res] = ranges[i].right;
                res++;
            }
        }
        System.out.println(res);
    }

    static public class Range{
        int left,right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
