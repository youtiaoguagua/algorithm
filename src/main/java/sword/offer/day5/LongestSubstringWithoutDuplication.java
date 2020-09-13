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

    public int longestSubstringWithoutDuplication2(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0,j=0; j < chars.length; j++) {
            Integer merge = map.merge(chars[j], 1, Integer::sum);
            if (merge>1){
                while (map.get(chars[i])!=2){
                    map.merge(chars[i],-1,Integer::sum);
                    i++;
                }
                map.merge(chars[i],-1,Integer::sum);
                i++;
            }

            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutDuplication t = new LongestSubstringWithoutDuplication();
        int abcabc = t.longestSubstringWithoutDuplication2("mchbmmcgc");
        System.out.println(abcabc);
    }
}
