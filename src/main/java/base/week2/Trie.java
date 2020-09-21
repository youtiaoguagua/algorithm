package base.week2;

import java.util.Scanner;

/**
 * Trie字符串统计
 * @author youtiaoguagua
 * @date 2020/9/21 01:19
 * 维护一个字符串集合，支持两种操作：
 * “I x”向集合中插入一个字符串x；
 * “Q x”询问一个字符串在集合中出现了多少次。
 * 共有N个操作，输入的字符串总长度不超过 105，字符串仅包含小写英文字母。
 * 输入格式
 * 第一行包含整数N，表示操作数。
 * 接下来N行，每行包含一个操作指令，指令为”I x”或”Q x”中的一种。
 * 输出格式
 * 对于每个询问指令”Q x”，都要输出一个整数作为结果，表示x在集合中出现的次数。
 * 每个结果占一行。
 * 数据范围
 * 1≤N≤2∗104
 * 输入样例：
 * 5
 * I abc
 * Q abc
 * Q ab
 * I ab
 * Q ab
 * 输出样例：
 * 1
 * 0
 * 1
 */
public class Trie {
    static int[][] son = new int[100010][26];
    static int[] cnt = new int[100010];
    static int indx = 0;
    public static void insert(char[] str){
        int p = 0;
        for (char c : str) {
            int tmp = c-'a';
            if (son[p][tmp]==0){
                son[p][tmp] = ++indx;
            }
            p = son[p][tmp];
        }
        cnt[p]+=1;
    }

    public static int query(char[] str) {
        int p = 0;
        for (char c : str) {
            int tmp = c-'a';
            if (son[p][tmp]==0){
                return 0;
            }else {
                p = son[p][tmp];
            }
        }
        return cnt[p];
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            String s = scanner.next();
            if (next.equals("I")){
                insert(s.toCharArray());
            }else {
                int query = query(s.toCharArray());
                System.out.println(query);
            }
        }
    }
}
