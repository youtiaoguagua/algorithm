package base.week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 排列数字
 * @author youtiaoguagua
 * @date 2020/9/22 14:31
 * 给定一个整数n，将数字1~n排成一排，将会有很多种排列方法。
 * 现在，请你按照字典序将所有的排列方法输出。
 * 输入格式
 * 共一行，包含一个整数n。
 * 输出格式
 * 按字典序输出所有排列方案，每个方案占一行。
 * 数据范围
 * 1≤n≤7
 * 输入样例：
 * 3
 * 输出样例：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 */
public class ArrangeNum {

    private static int[] nums;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];
        res = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }

        for (int i = 0; i < n; i++) {
            dfs(i);
        }
    }
    static int[] res;
    static int index;

    private static void dfs(int x) {
        int tmp = nums[x];
        res[index++] = tmp;
        if (index==n){
            Arrays.stream(res).forEach(a->System.out.printf("%d ",a));
            System.out.println();
        }
        nums[x] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==Integer.MIN_VALUE){
                continue;
            }
            dfs(i);
        }
        index--;
        nums[x] = tmp;
    }
}
