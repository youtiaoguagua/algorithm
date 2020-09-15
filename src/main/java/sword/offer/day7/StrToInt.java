package sword.offer.day7;

/**
 * 把字符串转换成整数
 * @author youtiaoguagua
 * @date 2020/9/16 01:05
 * 请你写一个函数StrToInt，实现把字符串转换成整数这个功能。
 * 当然，不能使用atoi或者其他类似的库函数。
 * 样例
 * 输入："123"
 * 输出：123
 * 注意:
 * 你的函数应满足下列条件：
 * 忽略所有行首空格，找到第一个非空格字符，可以是 ‘+/−’ 表示是正数或者负数，紧随其后找到最长的一串连续数字，将其解析成一个整数；
 * 整数后可能有任意非数字字符，请将其忽略；
 * 如果整数长度为0，则返回0；
 * 如果整数大于INT_MAX(2^31 − 1)，请返回INT_MAX；如果整数小于INT_MIN(−2^31) ，请返回INT_MIN；
 */
public class StrToInt {
    public int strToInt(String str) {
        if (str.length()==0){
            return 0;
        }
        int k = 0;
        while (k<str.length()&&str.charAt(k)==' '){
            k++;
        }
        if (k<str.length()&&str.charAt(k)=='+'){
            k++;
        }
        boolean isMinus = false;
        if (k<str.length()&&str.charAt(k)=='-'){
            k++;
            isMinus = true;
        }
        long res =0;
        while (k<str.length()&&str.charAt(k)>='0'&&str.charAt(k)<='9'){
            res =res*10+str.charAt(k)-'0';
            k++;
        }
        if (isMinus){
            res*=-1;
        }
        if (res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if (res<Integer.MIN_VALUE){
            return  Integer.MIN_VALUE;
        }
        return (int) res;

    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        int i = strToInt.strToInt("11111111111111");
        System.out.println(i);
    }
}
