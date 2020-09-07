package sword.offer.day2;

import java.util.Arrays;

/**
 * ��������1�ĸ���
 *
 * @author youtiaoguagua
 * @date 2020/9/7 ���� 11:22
 * ����һ��32λ������������������Ʊ�ʾ��1�ĸ�����
 * ע�⣺
 * �����ڼ�������������ֵ�Ĳ�������ʾ��
 * ����1
 * ���룺9
 * �����2
 * ���ͣ�9�Ķ����Ʊ�ʾ��1001��һ����2��1��
 * ����2
 * ���룺-2
 * �����31
 * ���ͣ�-2�ڼ������ᱻ��ʾ��11111111111111111111111111111110��
 * һ����31��1��
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1'){
                count++;
            }
        }
        return count;
    }

    /**
     * ������
     */
    public int NumberOf2(int n) {
        int res = 0;
        while (n!=0){
            //a&1����������ͬ��1ʱ��1��������0��a&1���൱���ж��Ƿ���һ��1
            //a>>1,����һ��ȡ��һ��1ʱ��Ӧ�����ƣ�����һλ��������
            res+=n&1;
            n=n>>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1 numberOf1 = new NumberOf1();
        int i = numberOf1.NumberOf2(-1);
        System.out.println(i);
    }
}
