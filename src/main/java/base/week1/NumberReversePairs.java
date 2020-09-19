package base.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 逆序对的数量
 * @author youtiaoguagua
 * @date 2020/9/19 17:02
 * 给定一个长度为n的整数数列，请你计算数列中的逆序对的数量。
 * 逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i < j 且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * 输入格式
 * 第一行包含整数n，表示数列的长度。
 * 第二行包含 n 个整数，表示整个数列。
 * 输出格式
 * 输出一个整数，表示逆序对的个数。
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 6
 * 2 3 4 5 6 1
 * 输出样例：
 * 5
 */
public class NumberReversePairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        String s1 = reader.readLine();
        String[] s2 = s1.split(" ");
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(s2[i]);
        }

        numberReverse(ints,0,ints.length-1);
        System.out.println(res);

    }
    static long res = 0;

    public static void numberReverse(int[] nums, int left, int right){
        if (left>=right){
            return;
        }
        int mid = right+left>>1;
        numberReverse(nums,left,mid);
        numberReverse(nums,mid+1,right);

        int[] tmp = new int[right - left + 1];
        int l =left,r=mid+1,index=0;
        while ( l <=mid&&r<=right) {
            if (nums[l]<=nums[r]){
                tmp[index++] = nums[l++];
            }else {
                res+=mid-l+1;
                tmp[index++] = nums[r++];
            }
        }

        while (l<=mid){
            tmp[index++] = nums[l++];
        }

        while (r<=right){
            tmp[index++] = nums[r++];
        }

        for (int i = left,j = 0; i <=right ; i++,j++) {
            nums[i] = tmp[j];
        }
    }
}
