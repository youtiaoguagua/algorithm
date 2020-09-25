package base.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 试除法求约数
 * @author youtiaoguagua
 * @date 2020/9/25 23:22
 * 给定n个正整数ai，对于每个整数ai,请你按照从小到大的顺序输出它的所有约数。
 * 输入格式
 * 第一行包含整数n。
 * 接下来n行，每行包含一个整数ai。
 * 输出格式
 * 输出共n行，其中第 i 行输出第 i 个整数ai的所有约数。
 * 数据范围
 * 1≤n≤100,
 * 2≤ai≤2∗109
 * 输入样例：
 * 2
 * 6
 * 8
 * 输出样例：
 * 1 2 3 6
 * 1 2 4 8
 */
public class ApproximateNumber {

    public static ArrayList<Integer> solve(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n/i; i++) {
            if (n%i==0){
               list.add(i);
               if (i!=n/i){
                   list.add(n/i);
               }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            ArrayList<Integer> solve = solve(t);
            //for (Integer integer : solve) {
            //    System.out.printf("%d ",integer);
            //}
            System.out.println(solve.size());
        }
    }
}
