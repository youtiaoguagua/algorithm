package base.week2;

/**
 * 滑动窗口
 * @author youtiaoguagua
 * @date 2020/9/20 21:26
 * 给定一个大小为n≤106的数组。
 * 有一个大小为k的滑动窗口，它从数组的最左边移动到最右边。
 * 您只能在窗口中看到k个数字。
 * 每次滑动窗口向右移动一个位置。
 * 以下是一个例子：
 * 该数组为[1 3 -1 -3 5 3 6 7]，k为3。
 * 窗口位置	最小值	最大值
 * [1 3 -1] -3 5 3 6 7	-1	3
 * 1 [3 -1 -3] 5 3 6 7	-3	3
 * 1 3 [-1 -3 5] 3 6 7	-3	5
 * 1 3 -1 [-3 5 3] 6 7	-3	5
 * 1 3 -1 -3 [5 3 6] 7	3	6
 * 1 3 -1 -3 5 [3 6 7]	3	7
 * 您的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
 * 输入格式
 * 输入包含两行。
 * 第一行包含两个整数n和k，分别代表数组长度和滑动窗口的长度。
 * 第二行有n个整数，代表数组的具体数值。
 * 同行数据之间用空格隔开。
 * 输出格式
 * 输出包含两个。
 * 第一行输出，从左至右，每个位置滑动窗口中的最小值。
 * 第二行输出，从左至右，每个位置滑动窗口中的最大值。
 * 输入样例：
 * 8 3
 * 1 3 -1 -3 5 3 6 7
 * 输出样例：
 * -1 -3 -3 -3 3 3
 * 3 3 5 5 6 7
 */

import java.io.*;
import java.util.LinkedList;
public class SlidingWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] nums = new int[n];
        String[] s1 = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        slidingWindow(nums,k);
    }

    public static void slidingWindow(int[] nums, int k) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        //int left = 0;
        int right = 0;
        int[] maxData = new int[nums.length - k + 1];
        int[] minData = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int index = 0;
        while (right< nums.length){
            if (!list.isEmpty()&&list.peekFirst()<right-k+1){
                list.pollFirst();
            }

            if (!max.isEmpty()&&max.peekFirst()<right-k+1){
                max.pollFirst();
            }

            while (!list.isEmpty()&&nums[right] <= nums[list.peekLast()]) {
                list.pollLast();
            }

            while (!max.isEmpty()&&nums[right] >= nums[max.peekLast()]) {
                max.pollLast();
            }

            list.add(right);
            max.add(right);
            if (right-k+1>=0){
               minData[index] = nums[list.peekFirst()];
               maxData[index] = nums[max.peekFirst()];
               index++;
            }
            right++;
        }

        for (int i = 0; i < minData.length; i++) {
            writer.write(minData[i]+" ");
        }
        writer.write("\n");
        for (int i = 0; i < minData.length; i++) {
            writer.write(maxData[i]+" ");
        }
        writer.flush();
        writer.close();
    }
}
