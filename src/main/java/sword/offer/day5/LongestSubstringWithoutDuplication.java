package sword.offer.day5;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 最长不含重复字符的子字符串
 * @author youtiaoguagua
 * @date 2020/9/13 16:19
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。
 * 样例
 * 输入："abcabc"
 * 输出：3
 */
public class LongestSubstringWithoutDuplication {
    public int longestSubstringWithoutDuplication(String s) {
        if (s.length()==0){
            return 0;
        }else if (s.length()==1){
            return 1;
        }
        //HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        int left = 0;
        int right =1;
        int max = 1;
        while (right<chars.length){
            int tmp = left;
            while (chars[tmp]!=chars[right]&&tmp<right){
                tmp++;
            }

            if (tmp!=right){
                left = tmp+1;
            }

            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutDuplication t = new LongestSubstringWithoutDuplication();
        int abcabc = t.longestSubstringWithoutDuplication("chbmmcgc");
        System.out.println(abcabc);
    }
}
