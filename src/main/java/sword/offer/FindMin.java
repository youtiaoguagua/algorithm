package sword.offer;

/**
 * 旋转数组的最小数字
 * @author youtiaoguagua
 * @date 2020/9/7 上午 1:47
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个升序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 数组可能包含重复项。
 * 注意：数组内所含元素非负，若数组大小为0，请返回-1。
 * 样例
 * 输入：nums=[2,2,2,0,1]
 * 输出：0
 */
public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        if (nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        int min = nums[nums.length-1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (min>=nums[i]){
                min = nums[i];
            }else {
                return min;
            }
        }
        return -1;
    }

    /**
     * 优化（）二分法
     */
    public int findMin2(int[] nums) {
        int n = nums.length - 1;
        if (n<0){
            return -1;
        }

        while (n>0&&nums[0]==nums[n]){
            n--;
        }

        int left=0,right=n;
        while (left < right) {
            int mid = left+right>>1;
            if (nums[0]<=nums[mid]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return nums[right];

    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int min = findMin.findMin2(new int[]{2, 2, 2, 0, 1});
        System.out.println(min);
    }
}
