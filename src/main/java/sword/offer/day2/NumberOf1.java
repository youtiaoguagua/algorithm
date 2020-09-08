package sword.offer.day2;

import java.util.Arrays;

/**
 * 二进制中1的个数
 *
 * @author youtiaoguagua
 * @date 2020/9/7 下午 11:22
 * 输入一个32位整数，输出该数二进制表示中1的个数。
 * 注意：
 * 负数在计算机中用其绝对值的补码来表示。
 * 样例1
 * 输入：9
 * 输出：2
 * 解释：9的二进制表示是1001，一共有2个1。
 * 样例2
 * 输入：-2
 * 输出：31
 * 解释：-2在计算机里会被表示成11111111111111111111111111111110，
 * 一共有31个1。
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1'){
                count++;
            }
        }
        return count;
    }

    /**
     * 升级版
     */
    public int NumberOf2(int n) {
        int res = 0;
        while (n!=0){
            //a&1，当二进制同是1时是1，否则是0，a&1，相当于判断是否有一个1
            //a>>1,当上一步取出一个1时候，应该右移，到下一位继续操作
            res+=n&1;
            n=n>>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1 numberOf1 = new NumberOf1();
        int i = numberOf1.NumberOf2(-1);
        System.out.println(i);
    }
}
