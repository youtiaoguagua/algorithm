package base.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 区间和
 * @author youtiaoguagua
 * @date 2020/9/18 00:37
 * 假定有一个无限长的数轴，数轴上每个坐标上的数都是0。
 * 现在，我们首先进行 n 次操作，每次操作将某一位置x上的数加c。
 * 接下来，进行 m 次询问，每个询问包含两个整数l和r，你需要求出在区间[l, r]之间的所有数的和。
 * 输入格式
 * 第一行包含两个整数n和m。
 * 接下来 n 行，每行包含两个整数x和c。
 * 再接下里 m 行，每行包含两个整数l和r。
 * 输出格式
 * 共m行，每行输出一个询问中所求的区间内数字和。
 * 数据范围
 * −109≤x≤109 ,
 * 1≤n,m≤105,
 * −109≤l≤r≤109,
 * −10000≤c≤10000
 * 输入样例：
 * 3 3
 * 1 2
 * 3 6
 * 7 5
 * 1 3
 * 4 6
 * 7 8
 * 输出样例：
 * 8
 * 0
 * 5
 */
public class RangeSum {
   static TreeMap<Integer, Integer> map = new TreeMap<>();
   static ArrayList<Pail> map2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] s1 = s.split(" ");
        int i1 = Integer.parseInt(s1[0]);
        for (int i = 1; i <= i1; i++) {
            String s2 = reader.readLine();
            String[] s3 = s2.split(" ");
            map.merge(Integer.parseInt(s3[0]),Integer.parseInt(s3[1]),Integer::sum);
        }

        for (int i = 0; i < Integer.parseInt(s1[1]); i++) {
            String s2 = reader.readLine();
            String[] s3 = s2.split(" ");
            int a = Integer.parseInt(s3[0]);
            int b = Integer.parseInt(s3[1]);
            map2.add(new Pail(a,b));
            map.merge(a, 0, Integer::sum);
            map.merge(b, 0, Integer::sum);
        }

        int[] ints = new int[map.size()+1];
        int[] vals = new int[map.size()+1];
        int a =1;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            ints[a] = integerIntegerEntry.getKey();
            vals[a] = integerIntegerEntry.getValue()+vals[a-1];
            a++;
        }
        for (Pail pail : map2) {
            Integer left = pail.left;
            Integer right = pail.right;
            int count = getIndex(left,ints);
            int count2 = getIndex(right,ints);
            int i = vals[count2] - vals[count - 1];
            System.out.println(i);
        }
    }

    private static int getIndex(Integer key, int[] ints) {
        int left=1;int right=ints.length-1;
        while (left<right) {
            int mid = left+right+1>>1;
            if (ints[mid]<=key){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    static class Pail{
        int left;
        int right;

        public Pail(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


}
