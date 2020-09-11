package sword.offer.day4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 * @author youtiaoguagua
 * @date 2020/9/11 23:20
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 假设数组非空，并且一定存在满足条件的数字。
 * 思考题：
 * 假设要求只能使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？
 * 样例
 * 输入：[1,2,1,1,3]
 * 输出：1
 */
public class MoreThanHalfNum {

    public int moreThanHalfNum_Solution2(int[] nums) {
        int count =0;
        int val = -1;
        for (int num : nums) {
            if (count==0){
                val = num;
                count = 1;
            }else {
                if (val==num){
                    count++;
                }else {
                    count--;
                }
            }
        }
        return val;
    }

    public int moreThanHalfNum_Solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                Integer integer = map.get(nums[i]);
                map.put(nums[i],integer+1);
                continue;
            }
            map.put(nums[i],1);
        }

        int max = 0;
        int value=0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue()>max){
                max = integerIntegerEntry.getValue();
                value = integerIntegerEntry.getKey();
            }
        }
        return value;
    }
}
