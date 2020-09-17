package base.week1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 最长连续不重复子序列
 * @author youtiaoguagua
 * @date 2020/9/17 20:30
 * 给定一个长度为n的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。
 * 输入格式
 * 第一行包含整数n。
 * 第二行包含n个整数（均在0~100000范围内），表示整数序列。
 * 输出格式
 * 共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 1 2 2 3 5
 * 输出样例：
 * 3
 */
public class LongestNotRepeatStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int a = longNotRepeat(nums);
        System.out.println(a);
    }

    private static int longNotRepeat(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int left=0,right=0; right < nums.length; right++) {
            Integer merge = map.merge(nums[right], 1, Integer::sum);
            if (merge>1){
                while (nums[left]!=nums[right]){
                    map.merge(nums[left], -1, Integer::sum);
                    left++;
                }
                map.merge(nums[left], -1, Integer::sum);
                left++;
            }

            max  = Math.max(max, right - left + 1);
        }
        return max;
    }
}
