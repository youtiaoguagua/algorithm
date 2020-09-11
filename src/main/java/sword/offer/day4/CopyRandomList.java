package sword.offer.day4;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 复杂链表的复刻
 *
 * @author youtiaoguagua
 * @date 2020/9/11 09:56
 * 请实现一个函数可以复制一个复杂链表。
 * 在复杂链表中，每个结点除了有一个指针指向下一个结点外，还有一个额外的指针指向链表中的任意结点或者null。
 * 注意：
 * 函数结束后原链表要与输入时保持一致。
 */
public class CopyRandomList {

    /**
     * 优化版
     */
    public ListNode copyRandomList2(ListNode head) {
        for (ListNode i = head; i !=null ; i = i.next) {
            ListNode listNode = new ListNode(i.val);
            ListNode tmp = i.next;
            i.next = listNode;
            i.next.next = tmp;
        }

        for (ListNode i = head; i !=null ; i = i.next.next) {
            if (i.random!=null){
                i.next.random = i.random.next;
            }
        }
        ListNode root = new ListNode(-1);
        ListNode tmp = root;

        for (ListNode i = head.next; i !=null ; i = i.next.next) {
            tmp.next = i;
            tmp = tmp.next;

        }

        return root.next;

    }

    public ListNode copyRandomList(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur!=null){
            map.put(cur,new ListNode(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random =map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    static class ListNode {
        int val;

        ListNode next, random;

        ListNode(int x) {
            this.val = x;
        }
    }
}
