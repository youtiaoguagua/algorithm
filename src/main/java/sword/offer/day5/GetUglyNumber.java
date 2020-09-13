package sword.offer.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 丑数
 * @author youtiaoguagua
 * @date 2020/9/13 18:45
 * 我们把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 求第n个丑数的值。
 * 样例
 * 输入：5
 * 输出：5
 * 注意：习惯上我们把1当做第一个丑数。
 */
public class GetUglyNumber {
    public int getUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i=0,j=0,k=0;
        while (n>1){
            Integer max = Collections
                    .min(Arrays.asList(list.get(i) * 2
                            , list.get(j) * 3, list.get(k) * 5));
            list.add(max);
            if (list.get(i)*2==max){
                i++;
            }
            if (list.get(j)*3==max){
                j++;
            }
            if (list.get(k)*5==max){
                k++;
            }
            n--;
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        int uglyNumber = getUglyNumber.getUglyNumber(110);
        System.out.println(uglyNumber);
    }
}
