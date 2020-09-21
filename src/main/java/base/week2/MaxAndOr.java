package base.week2;



/**
 * 最大异或对
 * @author youtiaoguagua
 * @date 2020/9/22 00:06
 * 在给定的N个整数A1，A2……AN中选出两个进行xor（异或）运算，得到的结果最大是多少？
 * 输入格式
 * 第一行输入一个整数N。
 * 第二行输入N个整数A1～AN。
 * 输出格式
 * 输出一个整数表示答案。
 * 数据范围
 * 1≤N≤105,
 * 0≤Ai<231
 * 输入样例：
 * 3
 * 1 2 3
 * 输出样例：
 * 3
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class MaxAndOr {


    private static int[][] son = new int[31*100010][2];
    private static int index = 0;

    public static void insert(int x){
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int t = x>>i&1;
            if (son[p][t]==0){
                son[p][t] = ++index;
            }
            p = son[p][t];
        }
    }

    public static int query(int x){
        int p = 0;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int t = x>>i&1;
            if (son[p][t^1]!=0){
                p = son[p][t^1];
                res = res*2+(t^1);
            }else {
                p = son[p][t];
                res = res*2+t;
            }
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        int n =Integer.parseInt(s);
        int max = Integer.MIN_VALUE;
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            insert(num);
            int query = query(num);
            max = Math.max(max, query^num);
        }
        writer.write(String.valueOf(max));
        writer.flush();
        writer.close();
    }

}