package sword.offer.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 和为S的连续正数序列
 * @author youtiaoguagua
 * @date 2020/9/14 20:09
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
 * 样例
 * 输入：15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class FindContinuousSequence {

    /**
     * 优化版
     */
    public List<List<Integer>> findContinuousSequence2(int sum) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for(int i=1,j=1,k=1;i<=sum;i++){
            while (k<sum){
                j++;
                k+=j;
            }

            if (k==sum&&j-i>0){
                List<Integer> collect = IntStream.range(i, j + 1).mapToObj(Integer::new).collect(Collectors.toList());
                lists.add(collect);
            }
            k-=i;
        }
        return lists;
    }

    public List<List<Integer>> findContinuousSequence(int sum) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i < (sum>>1)+2; i++) {
            int target = 2 * sum - (i - i * i);
            for (int j = i+1; j < (sum>>1)+2; j++) {
               if ( j*j+j == target){
                   List<Integer> collect = IntStream.range(i, j+1).mapToObj(Integer::new).collect(Collectors.toList());
                   lists.add(collect);
                   break;
               }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        List<List<Integer>> continuousSequence = findContinuousSequence.findContinuousSequence(15);
        System.out.println(continuousSequence);
    }
}
