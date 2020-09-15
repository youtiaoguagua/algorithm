package sword.offer.day7;

/**
 * 求1+2+…+n
 * @author youtiaoguagua
 * @date 2020/9/15 17:18
 * 求1+2+…+n,要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 样例
 * 输入：10
 * 输出：55
 */
public class GetSum {
    public int getSum(int n) {
        int res = n;
        boolean flag = n>0&&((res+=getSum(n-1))>0);
        return res;
    }
}
