package base.week2;


/**
 * 字符串哈希
 * @author youtiaoguagua
 * @date 2020/9/21 23:44
 * 给定一个长度为n的字符串，再给定m个询问，每个询问包含四个整数l1,r1,l2,r2，请你判断[l1,r1]和[l2,r2]这两个区间所包含的字符串子串是否完全相同。
 * 字符串中只包含大小写英文字母和数字。
 * 输入格式
 * 第一行包含整数n和m，表示字符串长度和询问次数。
 * 第二行包含一个长度为n的字符串，字符串中只包含大小写英文字母和数字。
 * 接下来m行，每行包含四个整数l1,r1,l2,r2，表示一次询问所涉及的两个区间。
 * 注意，字符串的位置从1开始编号。
 * 输出格式
 * 对于每个询问输出一个结果，如果两个字符串子串完全相同则输出“Yes”，否则输出“No”。
 * 每个结果占一行。
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 8 3
 * aabbaabb
 * 1 3 5 7
 * 1 3 6 8
 * 1 2 1 2
 * 输出样例：
 * Yes
 * No
 * Yes
 */
import java.util.Scanner;
public class StrHash {
    static int N = 100010;
    static long[] h = new long[N];
    static long[] p = new long[N];
    static int P = 131;

    public static long find(int l, int r){
        long l1 = h[r] - h[l - 1] * p[r - l + 1];
        return l1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        char[] chars = s.toCharArray();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i-1]*P;
            h[i] = h[i-1]*P +chars[i-1];
        }

        for (int i = 0; i < m; i++) {
            int l1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            long l = find(l1, r1);
            long z = find(l2, r2);
            if (l==z){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
