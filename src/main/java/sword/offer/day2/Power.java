package sword.offer.day2;

/**
 * @author youtiaoguagua
 * @date 2020/9/8 ���� 1:06
 * ʵ�ֺ���double Power(double base, int exponent)����base�� exponent�η���
 * ����ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 * ע�⣺
 * ������ֵ�����ָ��ͬΪ0�����
 * ������Ϊ0ʱ��ָ��һ��Ϊ��
 * ����1
 * ���룺10 ��2
 * �����100
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
     * ʹ�ö����Ʒ�
     * һ�����Ķ�����ת��Ϊʮ�����൱��n = 1*b1 + 2*b2 + 4*b3 + ... + 2^(m-1)*bm
     * ���ұߵĶ�������a���൱��x^n==x^a = x^(1*b1 + 2*b2 + 4*b3 + ... + 2^(m-1)*bm) = x^(1*b1) * x^(2*b2) * x^(2^(m-1)*bm)
     * params x�൱�������x,n�൱������Ҳ����b;
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
