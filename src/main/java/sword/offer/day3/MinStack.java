package sword.offer.day3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 包含min函数的栈
 * @author youtiaoguagua
 * @date 2020/9/10 01:37
 * 设计一个支持push，pop，top等操作并且可以在O(1)时间内检索出最小元素的堆栈。
 * push(x)–将元素x插入栈中
 * pop()–移除栈顶元素
 * top()–得到栈顶元素
 * getMin()–得到栈中最小元素
 * 样例
 * MinStack minStack = new MinStack();
 * minStack.push(-1);
 * minStack.push(3);
 * minStack.push(-4);
 * minStack.getMin();   --> Returns -4.
 * minStack.pop();
 * minStack.top();      --> Returns 3.
 * minStack.getMin();   --> Returns -1.
 * 优化版 {@link sword.offer.day3.MinStack2}
 */
public class MinStack {
    private final Stack<Integer> stack;
    /** initialize your data structure here. */
    LinkedList<Integer> list;

    public MinStack() {
        list = new LinkedList<>();
        stack = new Stack<>();


    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
        list.sort((a,b)->{
            if (a<b){
                return -1;
            }
            if (a>b){
                return 1;
            }
            return 0;
        });
    }

    public void pop() {
        Integer pop = stack.pop();
        list.remove(pop);
    }

    public int top() {
        Integer peek = stack.peek();
        return peek;
    }

    public int getMin() {
        Integer first = list.getFirst();
        return first;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
    }
}
