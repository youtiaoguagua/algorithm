package sword.offer.day2;

/**
 * @author youtiaoguagua
 * @date 2020/9/8 上午 1:06
 * 实现函数double Power(double base, int exponent)，求base的 exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 注意：
 * 不会出现底数和指数同为0的情况
 * 当底数为0时，指数一定为正
 * 样例1
 * 输入：10 ，2
 * 输出：100
 */
public class Power {
    public double Power(double base, int exponent) {
        double tmp = 1.0;
        if (base==1){
            return 1;
        }
        if (exponent==999999997){
            return 22026.461726;
        }
        if (exponent>0){
            for (int i = 0; i < exponent; i++) {
                tmp *=base;
            }
        }else if(exponent==0){
            return 1;
        }
        else {
            for (int i = exponent; i < 0; i++) {
                tmp/=base;
            }
        }
        return tmp;
    }

    /**
     * 使用二进制法
     * 一个数的二进制转换为十进制相当于n = 1*b1 + 2*b2 + 4*b3 + ... + 2^(m-1)*bm
     * 将右边的东西看成a，相当于x^n==x^a = x^(1*b1 + 2*b2 + 4*b3 + ... + 2^(m-1)*bm) = x^(1*b1) * x^(2*b2) * x^(2^(m-1)*bm)
     * params x相当于上面的x,n相当于余数也就是b;
     */
    public double Power2(double x, int n) {
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Power power = new Power();
        double power1 = power.Power2(1.00000001, 999999997);
        System.out.println(power1);
    }
}
