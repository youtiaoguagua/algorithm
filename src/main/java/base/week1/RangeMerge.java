package base.week1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 区间合并
 * @author youtiaoguagua
 * @date 2020/9/19 10:38
 * 给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
 * 注意如果在端点处相交，也算有交集。
 * 输出合并完成后的区间个数。
 * 例如：[1,3]和[2,6]可以合并为一个区间[1,6]。
 * 输入格式
 * 第一行包含整数n。
 * 接下来n行，每行包含两个整数 l 和 r。
 * 输出格式
 * 共一行，包含一个整数，表示合并区间完成后的区间个数。
 * 数据范围
 * 1≤n≤100000 ,
 * −109≤li≤ri≤109
 * 输入样例：
 * 5
 * 1 2
 * 2 4
 * 5 6
 * 7 8
 * 7 9
 * 输出样例：
 * 3
 */
public class RangeMerge {

    private static ArrayList<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            pairs.add(new Pair(a,b));
        }
        rangeMerge();
    }

    public static void rangeMerge(){
        int res = 0;
        Collections.sort(pairs,(a,b)->a.left!=b.left?a.left-b.left:a.right-b.right);
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (Pair pair : pairs) {
            if (pair.left>right){
                if (right!=Integer.MIN_VALUE){
                    res+=1;
                }
                left = pair.left;
                right= pair.right;
            }else if (pair.left<=right&&pair.right<=right){
                right = right;
            }else if (pair.left<=right&&pair.right>right){
                right = pair.right;
            }
        }
        if (left!=Integer.MIN_VALUE){
            res+=1;
        }
        System.out.println(res);

    }


    static class Pair{
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
