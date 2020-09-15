package sword.offer.day7;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * 滑动窗口的最大值
 * @author youtiaoguagua
 * @date 2020/9/15 00:28
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * 例如，如果输入数组[2, 3, 4, 2, 6, 2, 5, 1]及滑动窗口的大小3,那么一共存在6个滑动窗口，它们的最大值分别为[4, 4, 6, 6, 6, 5]。
 * 注意：
 * 数据保证k大于0，且k小于等于数组长度。
 * 样例
 * 输入：[2, 3, 4, 2, 6, 2, 5, 1] , k=3
 * 输出: [4, 4, 6, 6, 6, 5]
 */
public class MaxInWindows {

    public int[] maxInWindows2(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty()&&queue.peek()<=i-k){
                queue.pop();
            }

            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if (i>=k-1){
                res[index] = nums[queue.peek()];
                index++;
            }
        }
        return res;
    }

    public int[] maxInWindows(int[] nums, int k) {
        int[] n = new int[nums.length-k+1];
        for (int i = 0; i <= nums.length-k; i++) {
            //for (int j = i; j < i+k; j++) {
                Integer integer = IntStream.range(i, i + k).mapToObj(a -> nums[a]).max((b, c) -> b - c).get();
                n[i] = integer;
            //}
        }
        return n;
    }
}
