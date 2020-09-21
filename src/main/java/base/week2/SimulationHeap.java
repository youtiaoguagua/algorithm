package base.week2;

import java.util.Scanner;

/**
 * 模拟堆
 * @author youtiaoguagua
 * @date 2020/9/21 16:52
 * 维护一个集合，初始时集合为空，支持如下几种操作：
 * “I x”，插入一个数x；
 * “PM”，输出当前集合中的最小值；
 * “DM”，删除当前集合中的最小值（数据保证此时的最小值唯一）；
 * “D k”，删除第k个插入的数；
 * “C k x”，修改第k个插入的数，将其变为x；
 * 现在要进行N次操作，对于所有第2个操作，输出当前集合的最小值。
 * 输入格式
 * 第一行包含整数N。
 * 接下来N行，每行包含一个操作指令，操作指令为”I x”，”PM”，”DM”，”D k”或”C k x”中的一种。
 * 输出格式
 * 对于每个输出指令“PM”，输出一个结果，表示当前集合中的最小值。
 * 每个结果占一行。
 * 数据范围
 * 1≤N≤105
 * −109≤x≤109
 * 数据保证合法。
 * 输入样例：
 * 8
 * I -10
 * PM
 * I -10
 * D 1
 * C 2 8
 * I 6
 * PM
 * DM
 * 输出样例：
 * -10
 * 6
 *
 */
public class SimulationHeap {
    static int[] nums = new int[10000010];
    static int size=0;
    static int[] ph = new int[10000010];
    static int[] hp = new int[10000010];

    public static void swap_heap(int i,int j){

        swap(nums,i,j);
        swap(hp,i,j);
        swap(ph,ph[ph[i]],ph[ph[j]]);
    }

    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void up(int u) {
        if (u/3>0&&nums[u/3]>nums[u]){
            swap_heap(u/3,u);
            up(u/3);
        }
    }

    public static void down(int u){
        int t = u;
        if (u*2+1<=size&&nums[u*2+1]<nums[t]){
            t = u*2+1;
        }

        if (u*2+2<=size&&nums[u*2+2]<nums[t]){
            t = u*2+2;
        }

        if (t!=u){
            swap(nums,t,u);
            down(t);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (s.equals("I")){
                int t = scanner.nextInt();
                m++;
                ph[m] = size;
                hp[size] = m;
                nums[size++] = t;
                down(t);
                up(t);
            }else if (s.equals("PM")){
                System.out.println(nums[0]);
            }else if (s.equals("DM")){
                swap_heap(0,size);
                size--;
                down(0);
            }else if (s.equals("D")){
                int t = scanner.nextInt();
                int z = ph[t];
                swap_heap(ph[t],size);
                size--;
                up(z);
                down(z);
            }else {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                nums[ph[k]] = x;
                up(ph[k]);
                down(ph[k]);
            }
        }
    }
}
