package sword.offer.day7;

/**
 * 不用加减乘除做加法
 * @author youtiaoguagua
 * @date 2020/9/16 00:12
 * 写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷ 四则运算符号。
 *
 * 样例
 * 输入：num1 = 1 , num2 = 2
 *
 * 输出：3
 */
public class Add {
    public int add(int num1, int num2) {
        while (num2!=0){
        int i = num1 ^ num2;
        int t = (num1 & num2) << 1;
            num1 = i;
            num2 = t;
        }
        return num1;
    }
}
