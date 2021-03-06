package sword.offer.day4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数据流中的中位数
 * @author youtiaoguagua
 * @date 2020/9/12 01:26
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 样例
 * 输入：1, 2, 3, 4
 * 输出：1,1.5,2,2.5
 * 解释：每当数据流读入一个数据，就进行一次判断并输出当前的中位数。
 */
public class GetMedianAndInsert {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public void insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double getMedian() {
        int i = list.size() / 2;
        if (list.size()%2==1){
            Integer integer = list.get(i);
            return Double.valueOf(integer);
        }else {
            int left = i-1;
            int i1 = list.get(left) + list.get(i);
            double v = i1 / 2.0;
            return v;
        }
    }
}
