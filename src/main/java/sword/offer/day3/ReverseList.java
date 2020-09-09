package sword.offer.day3;

import java.util.List;

/**
 * 反转链表
 * @author youtiaoguagua
 * @date 2020/9/9 上午 2:26
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * 思考题：
 * 请同时实现迭代版本和递归版本。
 * 样例
 * 输入:1->2->3->4->5->NULL
 * 输出:5->4->3->2->1->NULL
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newNode = new ListNode(-1);
        ListNode one = head;
        ListNode two = null;
        while (one!=null){
            two = one.next;
            ListNode tmp = newNode.next;
            newNode.next = one;
            one.next = tmp;
            one = two;
        }
        return newNode.next;
    }

    /**
     * 优化版
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode root = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(4);
        root.next = root2;
        root2.next = root3;
        root3.next = root4;
        ListNode listNode = reverseList.reverseList2(root);
    }

     static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
