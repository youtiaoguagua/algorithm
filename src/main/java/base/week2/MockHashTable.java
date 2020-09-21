package base.week2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 模拟散列表
 * @author youtiaoguagua
 * @date 2020/9/21 18:05
 * 维护一个集合，支持如下几种操作：
 * “I x”，插入一个数x；
 * “Q x”，询问数x是否在集合中出现过；
 * 现在要进行N次操作，对于每个询问操作输出对应的结果。
 * 输入格式
 * 第一行包含整数N，表示操作数量。
 * 接下来N行，每行包含一个操作指令，操作指令为”I x”，”Q x”中的一种。
 * 输出格式
 * 对于每个询问指令“Q x”，输出一个询问结果，如果x在集合中出现过，则输出“Yes”，否则输出“No”。
 * 每个结果占一行。
 * 数据范围
 * 1≤N≤105
 * −109≤x≤109
 * 输入样例：
 * 5
 * I 1
 * I 2
 * I 3
 * Q 2
 * Q 5
 * 输出样例：
 * Yes
 * No
 */
public class MockHashTable {
    static int idx = 0;
    static int[] nums = new int[100003];
    static int[] ne = new int[100003];
    static int[] e = new int[100003];

    public static void insert(int x){
        int hash = (x%100003+100003)%100003;
        e[idx] = x;
        ne[idx] = nums[hash];
        nums[hash] = idx++;
    }

    public static void query(int x) {
        int hash = (x%100003+100003)%100003;
        int num = nums[hash];
        for (int i = num; i !=-1 ; i=ne[i]) {
            if (e[i]==x){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

    public static void main(String[] args) {
        Arrays.fill(nums, -1);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            int x = scanner.nextInt();
            if (next.equals("I")){
                insert(x);
            }else {
                query(x);
            }
        }
    }
}
