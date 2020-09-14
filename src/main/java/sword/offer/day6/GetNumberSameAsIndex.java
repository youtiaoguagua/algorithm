package sword.offer.day6;

/**
 * 数组中数值和下标相等的元素
 * @author youtiaoguagua
 * @date 2020/9/14 09:48
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组[-3, -1, 1, 3, 5]中，数字3和它的下标相等。
 * 样例
 * 输入：[-3, -1, 1, 3, 5]
 * 输出：3
 * 注意:如果不存在，则返回-1。
 */
public class GetNumberSameAsIndex {

    public int getNumberSameAsIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left<right){
            int mid = left+right+1>>1;
            if (nums[mid]<=mid){
                left = mid;
            }else {
                right = mid-1;
            }
        }

        if (nums[left]!=left){
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        GetNumberSameAsIndex getNumberSameAsIndex = new GetNumberSameAsIndex();
        int numberSameAsIndex = getNumberSameAsIndex.getNumberSameAsIndex(new int[]{-5, -4, -3, 3, 7, 8, 9});
        System.out.println(numberSameAsIndex);
    }
}
