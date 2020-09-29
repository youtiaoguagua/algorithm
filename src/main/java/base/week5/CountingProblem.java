package base.week5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 计数问题
 * @author youtiaoguagua
 * @date 2020/9/29 09:12
 * 给定两个整数 a 和 b，求 a 和 b 之间的所有数字中0~9的出现次数。
 * 例如，a=1024，b=1032，则 a 和 b 之间共有9个数如下：
 * 1024 1025 1026 1027 1028 1029 1030 1031 1032
 * 其中‘0’出现10次，‘1’出现10次，‘2’出现7次，‘3’出现3次等等…
 * 输入格式
 * 输入包含多组测试数据。
 * 每组测试数据占一行，包含两个整数 a 和 b。
 * 当读入一行为0 0时，表示输入终止，且该行不作处理。
 * 输出格式
 * 每组数据输出一个结果，每个结果占一行。
 * 每个结果包含十个用空格隔开的数字，第一个数字表示‘0’出现的次数，第二个数字表示‘1’出现的次数，以此类推。
 * 数据范围
 * 0<a,b<100000000
 * 输入样例：
 * 1 10
 * 44 497
 * 346 542
 * 1199 1748
 * 1496 1403
 * 1004 503
 * 1714 190
 * 1317 854
 * 1976 494
 * 1001 1960
 * 0 0
 * 输出样例：
 * 1 2 1 1 1 1 1 1 1 1
 * 85 185 185 185 190 96 96 96 95 93
 * 40 40 40 93 136 82 40 40 40 40
 * 115 666 215 215 214 205 205 154 105 106
 * 16 113 19 20 114 20 20 19 19 16
 * 107 105 100 101 101 197 200 200 200 200
 * 413 1133 503 503 503 502 502 417 402 412
 * 196 512 186 104 87 93 97 97 142 196
 * 398 1375 398 398 405 499 499 495 488 471
 * 294 1256 296 296 296 296 287 286 286 247
 */
public class CountingProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b;
        while ((a= scanner.nextInt())!=0&&(b= scanner.nextInt())!=0){
            if (a>b){
                int tmp = a;
                a = b;
                b =tmp;
            }
            for (int i = 0; i < 10; i++) {
                int t = count(b,i)-count(a-1,i);
                System.out.printf("%d ",t);
            }
            System.out.println();
        }
    }

    private static int count(int val, int tar) {
        if (val==0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = val; i >0 ; i/=10) {
         list.add(i%10);
        }

        int res = 0;
        int start = list.size()-1;
        if (tar==0){
            start-=1;
        }
        for (int i = start; i >=0; i--) {
            if (i<list.size()-1){
                res+=getBefore(list,i+1,list.size()-1)*getLast(i);
                if (tar==0){
                    res -= getLast(i);
                }
            }
            if (list.get(i)==tar){
                res += getBefore(list, 0, i - 1)+1;
            }else if (list.get(i)>tar){
                res+=getLast(i);
            }
        }
        return res;
    }

    private static int getBefore(ArrayList<Integer> list, int left, int right) {
        int res= 0;
        for (int i = right; i >=left; i--) {
            res = res*10+list.get(i);
        }
        return res;
    }

    private static int getLast(int i) {
        int res = 1;
        for (int j = 0; j < i; j++) {
            res = res*10;
        }
        return res;
    }
}
