package base.week2;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author youtiaoguagua
 * @date 2020/9/20 01:24
 */
public class MonotonicStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();

            while (!stack.isEmpty()&&t<=stack.peek()){
                stack.pop();
            }
            if (!stack.isEmpty()&&t>stack.peek()){
                System.out.print(stack.peek()+" ");
            }
            if (stack.isEmpty()){
                System.out.print(-1+" ");
            }
            stack.push(t);
        }
    }
}
