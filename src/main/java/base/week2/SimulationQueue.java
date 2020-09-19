package base.week2;

import java.util.Scanner;

/**
 * 模拟队列
 * @author youtiaoguagua
 * @date 2020/9/20 01:07
 * 实现一个队列，队列初始为空，支持四种操作：
 * (1) “push x” – 向队尾插入一个数x；
 * (2) “pop” – 从队头弹出一个数；
 * (3) “empty” – 判断队列是否为空；
 * (4) “query” – 查询队头元素。
 * 现在要对队列进行M个操作，其中的每个操作3和操作4都要输出相应的结果。
 * 输入格式
 * 第一行包含整数M，表示操作次数。
 * 接下来M行，每行包含一个操作命令，操作命令为”push x”，”pop”，”empty”，”query”中的一种。
 * 输出格式
 * 对于每个”empty”和”query”操作都要输出一个查询结果，每个结果占一行。
 * 其中，”empty”操作的查询结果为“YES”或“NO”，”query”操作的查询结果为一个整数，表示队头元素的值。
 * 数据范围
 * 1≤M≤100000,
 * 1≤x≤109,
 * 所有操作保证合法。
 * 输入样例：
 * 10
 * push 6
 * empty
 * query
 * pop
 * empty
 * push 3
 * push 4
 * pop
 * query
 * push 6
 * 输出样例：
 * NO
 * 6
 * YES
 * 4
 */
public class SimulationQueue {

    static int[] queue = new int[100000 ];
    static int start = -1;
    static int end = 0;

    public static void push(int x){
        queue[++start] = x;
    }

    public static void pop(){
        end++;
    }


    public static void query(){
        System.out.println(queue[end]);
    }

    public static void empty(){
       if ( start-end+1>0){
           System.out.println("NO");
       }else {
           System.out.println("YES");
       }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            if (next.equals("push")){
                int r = scanner.nextInt();
                push(r);
            }else if (next.equals("pop")){
                pop();
            }else if (next.equals("query")){
                query();
            }else {
                empty();
            }
        }
    }
}
