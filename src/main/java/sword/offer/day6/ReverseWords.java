package sword.offer.day6;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * 翻转单词顺序
 * @author youtiaoguagua
 * @date 2020/9/14 21:07
 * 输入一个英文句子，单词之前用一个空格隔开，且句首和句尾没有多余空格。翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 * 样例
 * 输入："I am a student."
 * 输出："student. a am I"
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0,j= chars.length-1; i < j ; i++,j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j<s.length()&&chars[j]!=' '){
                j++;
            }
            for (int k = i,z=j-1; k <z; k++,z--) {
                char tmp = chars[k];
                chars[k] = chars[z];
                chars[z] = tmp;
            }
            i = j;
        }
        String s1 = new StringBuilder().append(chars).toString();
        return s1;
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = reverseWords.reverseWords("I am a student.");
        System.out.println(s);
    }
}
