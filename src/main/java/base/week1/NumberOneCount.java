package base.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 二进制中1的个数
 * @author youtiaoguagua
 * @date 2020/9/18 00:07
 * 给定一个长度为n的数列，请你求出数列中每个数的二进制表示中1的个数。
 * 输入格式
 * 第一行包含整数n。
 * 第二行包含n个整数，表示整个数列。
 * 输出格式
 * 共一行，包含n个整数，其中的第 i 个数表示数列中的第 i 个数的二进制表示中1的个数。
 * 数据范围
 * 1≤n≤100000,
 * 0≤数列中元素的值≤109
 * 输入样例：
 * 5
 * 1 2 3 4 5
 * 输出样例：
 * 1 1 2 1 2
 */
public class NumberOneCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        String s1 = reader.readLine();
        String[] s2 = s1.split(" ");
        for (int i = 0; i < n; i++) {
            numberOneCount(Integer.parseInt(s2[i]));
        }
    }

    public static void numberOneCount(int num){
        int count =0;
        while (num!=0){
            int i = num & -num;
            num-=i;
            count++;
        }
        System.out.printf("%d ",count);

    }
}
