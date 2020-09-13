package sword.offer.day5;

/**
 * 数字序列中某一位的数字
 * @author youtiaoguagua
 * @date 2020/9/12 16:42
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数求任意位对应的数字。
 * 样例
 * 输入：13
 * 输出：1
 */
public class DigitAtIndex {

    public int digitAtIndex(int n) {
        if (n==0){
            return 0;
        }
        //几位数
        int i =1;
        //*当输入较大值时会超出范围所以用long
        //当前的几位数的所有位数,
        long s =9;
        //当前的位数开始的数值
        int base=1;
        while (n>i*s){
            n-=i*s;
            i++;
            s*=10;
            base*=10;
        }

        int num = base+(n+i-1)/i-1;
        int t = n%i!=0?n%i:i;
        for (int j = 0; j < i-t; j++) {
            num /=10;
        }
        return num%10;
    }

    public static void main(String[] args) {
        DigitAtIndex digitAtIndex = new DigitAtIndex();
        int i = digitAtIndex.digitAtIndex(2147483647);
        System.out.println(i);
    }
}
