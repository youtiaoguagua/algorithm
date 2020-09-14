package sword.offer.day6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 数组中只出现一次的两个数字
 * @author youtiaoguagua
 * @date 2020/9/14 16:15
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 你可以假设这两个数字一定存在。
 * 样例
 * 输入：[1,2,3,3,4,4]
 * 输出：[1,2]
 */
public class FindNumsAppearOnce {

    public int[] findNumsAppearOnce2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum^=num;
        }
        int k =0;
        while ((sum>>k&1)==0){
            k++;
        }

        int first =0;
        for (int num : nums) {
            if ((num>>k&1)==0){
                first^=num;
            }
        }
        return new int[]{first, sum ^ first};
    }

    public int[] findNumsAppearOnce(int[] nums) {
        int[] res = new int[2];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue()==1){
                res[index++] = entry.getKey();
            }
        }
        return res;
    }
}
