package sword.offer.day6;

import java.util.Arrays;

/**
 * 左旋转字符串
 * @author youtiaoguagua
 * @date 2020/9/14 21:46
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 * 注意：
 * 数据保证n小于等于输入字符串的长度。
 * 样例
 * 输入："abcdefg" , n=2
 * 输出："cdefgab"
 */
public class LeftRotateString {

    public String leftRotateString2(String str, int n) {
        char[] chars = str.toCharArray();
        reserve(0,chars.length-1,chars);
        reserve(0,str.length()-n-1,chars);
        reserve(str.length()-n,str.length()-1,chars);
        return new String(chars);
    }

    public void reserve(int left,int right,char[] chars){
        while (left<right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    public String leftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        char[] res = Arrays.copyOfRange(chars, n, str.length()+n);
        for (int i = 0,j=str.length()-n; i < n; i++,j++) {
            res[j] = chars[i];
        }
        return new String(res);

    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        String fsadsafasdfas = leftRotateString.leftRotateString2("abcdefgh", 2);
        System.out.println(fsadsafasdfas);
    }
}
