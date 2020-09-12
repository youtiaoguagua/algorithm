package sword.offer.day4;

import java.util.PriorityQueue;

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
public class GetMedianAndInsert2 {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b)->b-a);
    public void insert(Integer num) {
        minHeap.add(num);
        if (!maxHeap.isEmpty()&&minHeap.peek()>maxHeap.peek()){
            Integer poll1 = minHeap.poll();
            Integer poll2 = maxHeap.poll();
            maxHeap.add(poll1);
            minHeap.add(poll2);
        }

        if (minHeap.size()>maxHeap.size()+1){
            maxHeap.add(minHeap.poll());
        }
    }

    public Double getMedian() {
        if ((minHeap.size()+maxHeap.size())%2==1){
            return Double.valueOf(minHeap.peek());
        }
        Integer max = maxHeap.peek();
        Integer min = minHeap.peek();
        double v = (max + min) / 2.0;
        return v;
    }
}
