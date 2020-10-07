package base.week3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 八数码
 * @author youtiaoguagua
 * @date 2020/10/8 00:19
 * 在一个3×3的网格中，1~8这8个数字和一个“x”恰好不重不漏地分布在这3×3的网格中。
 * 例如：
 * 1 2 3
 * x 4 6
 * 7 5 8
 * 在游戏过程中，可以把“x”与其上、下、左、右四个方向之一的数字交换（如果存在）。
 * 我们的目的是通过交换，使得网格变为如下排列（称为正确排列）：
 * 1 2 3
 * 4 5 6
 * 7 8 x
 * 例如，示例中图形就可以通过让“x”先后与右、下、右三个方向的数字交换成功得到正确排列。
 * 交换过程如下：
 * 1 2 3   1 2 3   1 2 3   1 2 3
 * x 4 6   4 x 6   4 5 6   4 5 6
 * 7 5 8   7 5 8   7 x 8   7 8 x
 * 现在，给你一个初始网格，请你求出得到正确排列至少需要进行多少次交换。
 * 输入格式
 * 输入占一行，将3×3的初始网格描绘出来。
 * 例如，如果初始网格如下所示：
 * 1 2 3
 * x 4 6
 * 7 5 8
 * 则输入为：1 2 3 x 4 6 7 5 8
 * 输出格式
 * 输出占一行，包含一个整数，表示最少交换次数。
 * 如果不存在解决方案，则输出”-1”。
 * 输入样例：
 * 2  3  4  1  5  x  7  6  8
 * 输出样例
 * 19
 */
public class EigitDigit {
    static String end = "12345678x";
    static HashMap<String, Integer> map = new HashMap<>();

    private static Integer bfs(String start) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        map.put(start, 0);
        int[] a = {0, 0, 1, -1}, b = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll.equals(end)) {
                return map.get(end);
            }
            int t = poll.indexOf('x');
            int x = t/3,y=t%3;
            for (int i = 0; i < 4; i++) {
                int row = x + a[i];
                int col = y + b[i];
                int d = row * 3 + col;
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    char[] chars = poll.toCharArray();
                    swap(chars,t,d);
                    String rep = new String(chars);
                    if (!map.containsKey(rep)) {
                        map.put(rep, map.get(poll) + 1);
                        queue.add(rep);
                    }
                }
            }

        }
        return -1;
    }

    private static void swap(char[] chars, int t, int d) {
        char tmp = chars[t];
        chars[t] = chars[d];
        chars[d] = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine().replace(" ","");
        Integer res = bfs(start);
        System.out.println(res);
    }
}
