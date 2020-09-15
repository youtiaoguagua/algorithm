package sword.offer.day7;

import java.util.Arrays;

/**
 * 扑克牌的顺子
 * @author youtiaoguagua
 * @date 2020/9/15 11:03
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，大小王可以看做任意数字。
 * 为了方便，大小王均以0来表示，并且假设这副牌中大小王均有两张。
 * 样例1
 * 输入：[8,9,10,11,12]
 * 输出：true
 * 样例2
 * 输入：[0,8,9,11,12]
 * 输出：true
 */
public class IsContinuous {

    public boolean isContinuous(int [] numbers) {
        if (numbers.length==0){
            return false;
        }
        Arrays.sort(numbers);
        int zero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==0){
                zero++;
                continue;
            }
            if (i-1<0||numbers[i-1]==0){
                continue;
            }
            if (numbers[i]>numbers[i-1]+1){
                zero -= (numbers[i] - numbers[i - 1] - 1);
                if (zero<0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsContinuous isContinuous = new IsContinuous();
        boolean continuous = isContinuous.isContinuous(new int[]{0, 3, 2, 6, 4});
        System.out.println(continuous);
    }
}
