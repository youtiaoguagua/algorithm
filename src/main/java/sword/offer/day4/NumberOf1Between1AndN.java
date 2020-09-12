package sword.offer.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 从1到n整数中1出现的次数
 * @author youtiaoguagua
 * @date 2020/9/12 10:48
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含“1”的数字有1，10，11和12，其中“1”一共出现了5次。
 * 样例
 * 输入： 12
 * 输出： 5
 */
public class NumberOf1Between1AndN {
    public int numberOf1Between1AndN_Solution(int n) {
        int res = 0;
        int digit = 1;
        int height = n/10;
        int low = 0;
        int cur = n%10;
        while (height!=0||cur!=0){
            if (cur==0){
                res += height * digit;
            }else if (cur==1){
                res+=height*digit+low+1;
            }else if (cur>1){
                res+=(height+1)*digit;
            }

            low += cur * digit;
            cur=height%10;
            height/=10;
            digit*=10;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN numberOf1Between1AndN = new NumberOf1Between1AndN();
        int i = numberOf1Between1AndN.numberOf1Between1AndN_Solution(12);
        System.out.println(i);
    }
}
