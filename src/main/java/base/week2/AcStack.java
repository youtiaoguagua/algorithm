package base.week2;

import java.util.Scanner;

/**
 * 模拟栈
 *
 * @author youtiaoguagua
 * @date 2020/9/20 00:04
 * 实现一个栈，栈初始为空，支持四种操作：
 * (1) “push x” – 向栈顶插入一个数x；
 * (2) “pop” – 从栈顶弹出一个数；
 * (3) “empty” – 判断栈是否为空；
 * (4) “query” – 查询栈顶元素。
 * 现在要对栈进行M个操作，其中的每个操作3和操作4都要输出相应的结果。
 * 输入格式
 * 第一行包含整数M，表示操作次数。
 * 接下来M行，每行包含一个操作命令，操作命令为”push x”，”pop”，”empty”，”query”中的一种。
 * 输出格式
 * 对于每个”empty”和”query”操作都要输出一个查询结果，每个结果占一行。
 * 其中，”empty”操作的查询结果为“YES”或“NO”，”query”操作的查询结果为一个整数，表示栈顶元素的值。
 * 数据范围
 * 1≤M≤100000,
 * 1≤x≤109
 * 所有操作保证合法。
 * 输入样例：
 * 10
 * push 5
 * query
 * push 6
 * pop
 * query
 * pop
 * empty
 * push 4
 * query
 * empty
 * 输出样例：
 * 5
 * 5
 * YES
 * 4
 * NO
 */
public class AcStack {
    static int[] stack = new int[100000];
    static int top = 0;

    public static void push(int x) {
        stack[top] = x;
        top++;
    }

    public static void query() {
        if (top - 1 < 0) {
            System.out.println(-1);
        } else {
            System.out.println(stack[top - 1]);
        }
    }

    public static void pop() {
        if (top-1>=0){
            top = top-1;
        }
    }

    public static void empty() {
        if (top-1<0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            if (next.equals("push")){
                int t = scanner.nextInt();
                push(t);
            }else if (next.equals("query")){
                query();
            }else if (next.equals("pop")){
                pop();
            }else {
                empty();
            }
        }
    }
}
