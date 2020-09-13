package sword.offer.day5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 字符串中第一个只出现一次的字符
 * @author youtiaoguagua
 * @date 2020/9/13 20:32
 * 在字符串中找出第一个只出现一次的字符。
 * 如输入"abaccdeff"，则输出b。
 * 如果字符串中不存在只出现一次的字符，返回#字符。
 * 样例：
 * 输入："abaccdeff"
 * 输出：'b'
 */
public class FirstNotRepeatingChar {
    public char firstNotRepeatingChar(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.merge(chars[i],1,Integer::sum);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return '#';
    }
}
