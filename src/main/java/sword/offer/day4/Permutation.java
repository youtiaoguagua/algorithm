package sword.offer.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 数字排列
 * @author youtiaoguagua
 * @date 2020/9/11 20:23
 * 输入一组数字（可能包含重复数字），输出其所有的排列方式。
 * 样例
 * 输入：[1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutation {

    private int[] nums;
    ArrayList<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permutation(int[] nums) {
        this.nums = nums;
        dfs(0);
        return list;
    }

    private void dfs(int index) {
        HashSet<Integer> set = new HashSet<>();
        if (index == nums.length-1){
            ArrayList<Integer> integers = new ArrayList<>();
            Arrays.stream(nums).forEach(integers::add);
            this.list.add(integers);
        }

        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])||nums[i]==Integer.MIN_VALUE){
               continue;
            }
            set.add(nums[i]);
            swap(index,i);
            dfs(index+1);
            swap(index,i);
        }
    }

    public void swap(int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        List<List<Integer>> permutation1 = permutation.permutation(new int[]{1, 2, 3});
        System.out.println(permutation1);
    }




}
