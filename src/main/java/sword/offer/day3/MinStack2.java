package sword.offer.day3;

import java.util.Stack;

/**
 * @author youtiaoguagua
 * @date 2020/9/10 02:13
 * 优化版
 * 原版 {@link sword.offer.day3.MinStack}
 */
public class MinStack2 {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack1.size() == 1) {
            stack2.push(x);
        }else if (x<=stack2.peek()){
            stack2.push(x);
        }
    }

    public void pop() {
        Integer pop = stack1.pop();
        if (pop.equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        Integer peek = stack1.peek();
        return peek;
    }

    public int getMin() {
        Integer peek = stack2.peek();
        return peek;
    }
}
