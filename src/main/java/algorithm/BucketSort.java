package algorithm;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] sort = bucketSort.sort(new int[]{53,3,542,748,14,214});
        String s = Arrays.toString(sort);
        System.out.println(s);
    }

    private int[] sort(int[] nums) {
        int[][] buckets = new int[10][nums.length];
        int[] bucketIndex = new int[10];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>max){
                max = nums[i];
            }
        }

        int tmp = 1;
        while ((max)>0){
            for (int i = 0; i < nums.length; i++) {
                int t = nums[i]/tmp % 10;
                buckets[t][bucketIndex[t]] = nums[i];
                bucketIndex[t] = bucketIndex[t]+1;
            }
            tmp*=10;

            int numsIndex = 0;
            for (int i = 0; i < bucketIndex.length; i++) {
                int t = 0;
                while (bucketIndex[i]>0){
                    nums[numsIndex] = buckets[i][t];
                    bucketIndex[i] = bucketIndex[i]-1;
                    t++;
                    numsIndex++;
                }
            }
            max = max/10;
        }
        return nums;
    }
}
