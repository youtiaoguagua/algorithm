package sword.offer;

/**
 *不修改数组找出重复的数字
 * @author youtiaoguagua
 * @date 2020/9/6 下午 2:14
 */
public class DuplicateInArray {

    /**
     * 给定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
     * 请找出数组中任意一个重复的数，但不能修改输入的数组。
     * 样例
     * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
     * 返回 2 或 3。
     */
    public static void main(String[] args) {
        DuplicateInArray duplicateInArray = new DuplicateInArray();
        int i = duplicateInArray.duplicateInArray2(new int[]{2, 3, 5, 4, 3, 2, 6, 7});
        System.out.println(i);

    }

    public int duplicateInArray(int[] nums) {
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;
            if (ints[nums[i]] == 2) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 优化版
     * l = 1  r = 7 m = 4;
     * [1,4] = 5
     * [5,7] = 3
     * l = 1 r = 4  m = 2
     * [1,2] = 2
     * [3,4] = 3
     * l = 3 r = 4 m = 3
     * [3,3] = 2
     * [4,4] = 1
     * l = 3 r = 3
     */
    public int duplicateInArray2(int[] nums){
        int left = 1;
        int right = nums.length-1;
        while (left<right){
            int middle = left+right>>1;
            int count = 0;
            for (int num : nums) {
                if (num>=left&&num<=middle){
                    count++;
                }
            }

            if (count>middle-left+1){
                right=middle;
            }else {
                left = middle+1;
            }
        }
        return left;
    }

}
