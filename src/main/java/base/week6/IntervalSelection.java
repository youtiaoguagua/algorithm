package base.week6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 区间选点
 * @author youtiaoguagua
 * @date 2020/9/30 00:32
 * 给定N个闭区间[ai,bi]，请你在数轴上选择尽量少的点，使得每个区间内至少包含一个选出的点。
 * 输出选择的点的最小数量。
 * 位于区间端点上的点也算作区间内。
 * 输入格式
 * 第一行包含整数N，表示区间数。
 * 接下来N行，每行包含两个整数ai,bi，表示一个区间的两个端点。
 * 输出格式
 * 输出一个整数，表示所需的点的最小数量。
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
public class IntervalSelection {

    private static int n;
    private static Struct[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new Struct[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            nums[i] = new Struct(a,b);
        }
        Arrays.sort(nums,(a,b)->a.right-b.right);
        int res = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Struct num = nums[i];
            if (num.left>pre){
                res++;
                pre = num.right;
            }
        }
        System.out.println(res);
    }

    static public class Struct{
        int left,right;

        public Struct(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
