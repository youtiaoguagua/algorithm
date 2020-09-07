package sword.offer.day1;

import java.util.Stack;

/**
 * @author youtiaoguagua
 * @date 2020/9/7 上午 12:52
 * 请用栈实现一个队列，支持如下四种操作：
 * push(x) – 将元素x插到队尾；
 * pop() – 将队首的元素弹出，并返回该元素；
 * peek() – 返回队首元素；
 * empty() – 返回队列是否为空；
 */
public class MyQueue {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.isEmpty()&&stack2.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(4);
        System.out.println(myQueue.peek());
        myQueue.push(0);
        myQueue.empty();
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());



    }
}
