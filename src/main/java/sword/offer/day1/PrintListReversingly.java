package sword.offer.day1;

import java.util.*;

/**
 * 从尾到头打印链表
 *
 * @author youtiaoguagua
 * @date 2020/9/6 下午 5:05
 */
public class PrintListReversingly {

    /**
     * 输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。
     * 返回的结果用数组存储。
     * 样例
     * 输入：[2, 3, 5]
     * 返回：[5, 3, 2]
     */
    public static void main(String[] args) {
        PrintListReversingly printListReversingly = new PrintListReversingly();
        int[] ints = printListReversingly.printListReversingly(new ListNode(1));
        System.out.println(ints);
    }

    public int[] printListReversingly(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    /**
     * 优化版
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
