package sword.offer.day2;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author youtiaoguagua
 * @date 2020/9/9 上午 12:08
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序。
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 * 样例
 * 输入：[1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int left = 0,right = array.length-1;
        while (left<right){
            while (left<right&&left<array.length&&array[left]%2!=0){
                left++;
            }

            while (left<right&&right>=0&&array[right]%2!=1){
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReOrderArray reOrderArray = new ReOrderArray();
        reOrderArray.reOrderArray(new int[]{1,2,3,4,5});

    }
}
