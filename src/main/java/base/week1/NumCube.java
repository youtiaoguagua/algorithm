package base.week1;

import java.util.Scanner;

/**
 * 数的三次方根
 * @author youtiaoguagua
 * @date 2020/9/19 14:17
 * 给定一个浮点数n，求它的三次方根。
 * 输入格式
 * 共一行，包含一个浮点数n。
 * 输出格式
 * 共一行，包含一个浮点数，表示问题的解。
 * 注意，结果保留6位小数。
 * 数据范围
 * −10000≤n≤10000
 * 输入样例：
 * 1000.00
 * 输出样例：
 * 10.000000
 */
public class NumCube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double target = scanner.nextDouble();
        double left = 0.0;
        double right = target/2;
        while (right-left>1e-8){
            double mid = (left+right)/2;
            double v = mid * mid * mid;
            if (v<target){
                left = mid;
            }else {
                right = mid;
            }
        }
        System.out.printf("%.6f",left);
    }
}
