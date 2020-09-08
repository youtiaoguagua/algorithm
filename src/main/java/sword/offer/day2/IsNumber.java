package sword.offer.day2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 表示数值的字符串
 * @author youtiaoguagua
 * @date 2020/9/8 下午 4:50
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 注意:
 * 小数可以没有整数部分，例如.123等于0.123；
 * 小数点后面可以没有数字，例如233.等于233.0；
 * 小数点前面和后面可以有数字，例如233.666;
 * 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
 * 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4;
 * 样例：
 * 输入: "0"
 * 输出: true
 */
public class IsNumber {
    public boolean isNumber(String s) {
        boolean matches = s.matches("([+,-]{0,1}(\\d+\\.{0,1}\\d*|\\d*\\.\\d+))|([+,-]{0,1}(\\d+\\.{0,1}\\d*|\\d*\\.\\d+)[e,E][+,-]{0,1})\\d+");
        return matches;
    }

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        boolean dsa = isNumber.isNumber("e1");
        System.out.println(dsa);

    }
}
