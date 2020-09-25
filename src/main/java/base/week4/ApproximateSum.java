package base.week4;

/**
 * 约数之和
 * @author youtiaoguagua
 * @date 2020/9/26 02:20
 * 给定n个正整数ai，请你输出这些数的乘积的约数之和，答案对109+7取模。
 * 输入格式
 * 第一行包含整数n。
 * 接下来n行，每行包含一个整数ai。
 * 输出格式
 * 输出一个整数，表示所给正整数的乘积的约数之和，答案需对109+7取模。
 * 数据范围
 * 1≤n≤100,
 * 1≤ai≤2∗109
 * 输入样例：
 * 3
 * 2
 * 6
 * 8
 * 输出样例：
 * 252
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ApproximateSum {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int max = (int)1e9+7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            judge(t);
        }
        long res = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int a = entry.getKey();
            int b = entry.getValue();
            long t =1;
            for (int i = 0; i < b; i++) {
                t=(t*a+1)%max;
            }
            res=res*t%max;
        }
        System.out.println(res);
    }

    public static void judge(int n){
        for (int i = 2; i <=n/i ; i++) {
            while (n%i==0){
                n/=i;
                map.merge(i,1,Integer::sum);
            }

        }
        if(n>1){
            map.merge(n,1,Integer::sum);
        }
    }
}
