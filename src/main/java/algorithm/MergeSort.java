package algorithm;

import java.util.Arrays;

/**
 * @author youtiaoguagua
 * @date 2020/9/13 22:46
 */
public class MergeSort {

    private static int[] arr;

    public static void main(String[] args) {
        // 对输入值进行初始化
        arr = new int[]{4, 2, 5, 7, 2};
        int n = arr.length;
        // 归并排序
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge_sort(0, n - 1);

        String s = Arrays.toString(arr);
        System.out.println(s);
    }


    // 归并排序
    private static void merge_sort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left+((right-left)>>1);
        merge_sort(left,mid);
        merge_sort(mid+1,right);
        int[] tmp = new int[right-left+1];
        int l = left;
        int r = mid+1;
        int k=0;
        while (l<=mid&&r<=right) {
            if (arr[l]<=arr[r]){
                tmp[k++] = arr[l++];
            }else {
                tmp[k++] = arr[r++];
            }
        }

        while (l<=mid){
            tmp[k++] = arr[l++];
        }

        while (r<=right){
            tmp[k++] = arr[r++];
        }

        k=0;
        for (int i = left; i <=right ; i++) {
            arr[i] = tmp[k++];
        }
    }
}
