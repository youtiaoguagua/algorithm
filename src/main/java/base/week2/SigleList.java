package base.week2;

import java.util.Scanner;

/**
 * 单链表
 * @author youtiaoguagua
 * @date 2020/9/19 20:28
 * 实现一个单链表，链表初始为空，支持三种操作：
 * (1) 向链表头插入一个数；
 * (2) 删除第k个插入的数后面的数；
 * (3) 在第k个插入的数后插入一个数
 * 现在要对该链表进行M次操作，进行完所有操作后，从头到尾输出整个链表。
 * 注意:题目中第k个插入的数并不是指当前链表的第k个数。例如操作过程中一共插入了n个数，则按照插入的时间顺序，这n个数依次为：第1个插入的数，第2个插入的数，…第n个插入的数。
 * 输入格式
 * 第一行包含整数M，表示操作次数。
 * 接下来M行，每行包含一个操作命令，操作命令可能为以下几种：
 * (1) “H x”，表示向链表头插入一个数x。
 * (2) “D k”，表示删除第k个输入的数后面的数（当k为0时，表示删除头结点）。
 * (3) “I k x”，表示在第k个输入的数后面插入一个数x（此操作中k均大于0）。
 * 输出格式
 * 共一行，将整个链表从头到尾输出。
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 * 输入样例：
 * 10
 * H 9
 * I 1 1
 * D 1
 * D 0
 * H 6
 * I 3 6
 * I 4 5
 * I 4 5
 * I 3 4
 * D 6
 * 输出样例：
 * 6 4 6 5
 */
public class SigleList {
    static int header = -1;
    static  int[] data = new int[100000];
    static int[] ne  = new int[100000];
    static int idx = 0;

    public static void addHeader(int x){
        data[idx] = x;
        ne[idx] = header;
        header = idx;
        idx++;
    }

    public static void add(int k,int x){
        data[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    public static void remove(int k){
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            char c = next.charAt(0);
            int t = scanner.nextInt();
            if (c=='H'){
                addHeader(t);
            }else if (c=='I'){
                int z = scanner.nextInt();
                add(t-1,z);
            }else {
                if (t==0){
                    header = ne[header];
                }else {
                    remove(t-1);
                }
            }
        }

        for (int i=header;i!=-1;i=ne[i]){
            System.out.printf(data[i]+" ");
        }
    }
}