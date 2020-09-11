package sword.offer.day4;

import java.util.*;

/**
 * 最小的k个数
 * @author youtiaoguagua
 * @date 2020/9/12 00:46
 * 输入n个整数，找出其中最小的k个数。
 * 注意：
 * 数据保证k一定小于等于输入数组的长度;
 * 输出数组内元素请按从小到大顺序排序;
 * 样例
 * 输入：[1,2,3,4,5,6,7,8] , k=4
 * 输出：[1,2,3,4]
 */
public class GetLeastNumbers {
    public List<Integer> getLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for (int i : input) {
            heap.add(i);
            if (heap.size()>k){
                heap.poll();
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!heap.isEmpty()) {
            list.addFirst(heap.poll());
        }

        return list;
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        List<Integer> leastNumbers_solution = getLeastNumbers.getLeastNumbers_Solution(new int[]{9, 6, 13, 8, 1}, 3);
        System.out.println(leastNumbers_solution);
    }
}
