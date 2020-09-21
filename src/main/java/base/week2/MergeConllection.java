package base.week2;


/**
 * 合并集合
 * @author youtiaoguagua
 * @date 2020/9/21 02:18
 * 一共有n个数，编号是1~n，最开始每个数各自在一个集合中。
 * 现在要进行m个操作，操作共有两种：
 * “M a b”，将编号为a和b的两个数所在的集合合并，如果两个数已经在同一个集合中，则忽略这个操作；
 * “Q a b”，询问编号为a和b的两个数是否在同一个集合中；
 * 输入格式
 * 第一行输入整数n和m。
 * 接下来m行，每行包含一个操作指令，指令为“M a b”或“Q a b”中的一种。
 * 输出格式
 * 对于每个询问指令”Q a b”，都要输出一个结果，如果a和b在同一集合内，则输出“Yes”，否则输出“No”。
 * 每个结果占一行。
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 5
 * M 1 2
 * M 3 4
 * Q 1 2
 * Q 1 3
 * Q 3 4
 * 输出样例：
 * Yes
 * No
 * Yes
 */
import java.io.*;
import java.util.Arrays;
public class MergeConllection {
   static int[] p = new int[100010];


    public static int find(int x){
        if (p[x]!=x){
            p[x] =  find(p[x]);
        }
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int m = s[1];
        for (int i = 0; i < m; i++) {
            String[] s1 = reader.readLine().split(" ");
            int a = Integer.parseInt(s1[1]);
            int b = Integer.parseInt(s1[2]);
            if (s1[0].equals("M")){
                p[find(a)] = find(b);
            }else {
                if (find(a)==find(b)){
                    writer.write("Yes");
                }else {
                    writer.write("No");
                }
                writer.write("\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
