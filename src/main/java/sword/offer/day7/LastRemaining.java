package sword.offer.day7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 圆圈中最后剩下的数字
 * @author youtiaoguagua
 * @date 2020/9/15 14:53
 * 0, 1, …, n-1这n个数字(n>0)排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 样例
 * 输入：n=5 , m=3
 * 输出：3
 */
public class LastRemaining {

    /**
     * 优化
     */
    public int lastRemaining2(int n, int m) {
        if (n==1){
            return 0;
        }
        return (lastRemaining(n-1,m)+m)%n;
    }

    public int lastRemaining(int n, int m) {
        LinkedList<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toCollection(LinkedList::new));

        int index = 0;
        while (list.size()>1){
            for (int i = 1; i <m ; i++) {
                index = (index+1)%list.size();
            }
            list.remove(index);
        }
        return list.getFirst();
    }
}
