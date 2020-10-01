package base.week6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 耍杂技的牛
 * @author youtiaoguagua
 * @date 2020/10/1 16:09
 * 农民约翰的N头奶牛（编号为1..N）计划逃跑并加入马戏团，为此它们决定练习表演杂技。
 * 奶牛们不是非常有创意，只提出了一个杂技表演：
 * 叠罗汉，表演时，奶牛们站在彼此的身上，形成一个高高的垂直堆叠。
 * 奶牛们正在试图找到自己在这个堆叠中应该所处的位置顺序。
 * 这N头奶牛中的每一头都有着自己的重量Wi以及自己的强壮程度Si。
 * 一头牛支撑不住的可能性取决于它头上所有牛的总重量（不包括它自己）减去它的身体强壮程度的值，现在称该数值为风险值，风险值越大，这只牛撑不住的可能性越高。
 * 您的任务是确定奶牛的排序，使得所有奶牛的风险值中的最大值尽可能的小。
 * 输入格式
 * 第一行输入整数N，表示奶牛数量。
 * 接下来N行，每行输入两个整数，表示牛的重量和强壮程度，第i行表示第i头牛的重量Wi以及它的强壮程度Si。
 * 输出格式
 * 输出一个整数，表示最大风险值的最小可能值。
 * 数据范围
 * 1≤N≤50000,
 * 1≤Wi≤10,000,
 * 1≤Si≤1,000,000,000
 * 输入样例：
 * 3
 * 10 3
 * 2 5
 * 3 3
 * 输出样例：
 * 2
 */
public class AcrobaticCow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int s = scanner.nextInt();
            pairs[i] = new Pair(w,w+s);
        }
        Arrays.sort(pairs,(a,b)->a.sum-b.sum);
        int res=Integer.MIN_VALUE,sum=0;
        for (int i = 0; i < n; i++) {
            int w = pairs[i].w;
            int s = pairs[i].sum-w;
            res = Math.max(res,sum-s);
            sum+=w;
        }
        System.out.println(res);
    }

    static public class Pair{
        int w;
        int sum;

        public Pair(int w, int sum) {
            this.w = w;
            this.sum = sum;
        }
    }
}
