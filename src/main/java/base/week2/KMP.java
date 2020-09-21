package base.week2;


/**
 * KMP字符串
 * @author youtiaoguagua
 * @date 2020/9/20 23:22
 * 给定一个模式串S，以及一个模板串P，所有字符串中只包含大小写英文字母以及阿拉伯数字。
 * 模板串P在模式串S中多次作为子串出现。
 * 求出模板串P在模式串S中所有出现的位置的起始下标。
 * 输入格式
 * 第一行输入整数N，表示字符串P的长度。
 * 第二行输入字符串P。
 * 第三行输入整数M，表示字符串S的长度。
 * 第四行输入字符串S。
 * 输出格式
 * 共一行，输出所有出现位置的起始下标（下标从0开始计数），整数之间用空格隔开。
 * 数据范围
 * 1≤N≤105
 * 1≤M≤106
 * 输入样例：
 * 3
 * aba
 * 5
 * ababa
 * 输出样例：
 * 0 2
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class KMP {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n+1];
        String t = scanner.next();
        for (int i = 1; i < n+1; i++) {
            p[i] = t.charAt(i-1);
        }
        int m = scanner.nextInt();
        int[] s = new int[m + 1];
        String d = scanner.next();
        for (int i = 1; i < m+1; i++) {
            s[i] = d.charAt(i-1);
        }
        kmp(n,p,m,s);
    }

    public static void kmp(int n, int[] p, int m, int[] s) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ne = new int[n + 1];
        int j = 0;
        for (int i = 2; i < n+1; i++) {
            while (j>0&&p[i]!=p[j+1]){
                j = ne[j];
            }
            if (p[i]==p[j+1]){
                j++;
            }
            ne[i] = j;
        }
        j=0;
        for (int i = 1; i <= m; i++) {
            while (j>0&&s[i]!=p[j+1]){
                j = ne[j];
            }
            if (s[i] == p[j+1]){
                j++;
            }
            if (j==n){
                writer.write(i-n+" ");
                j = ne[j];
            }
        }
        writer.flush();
        writer.close();
    }
}
