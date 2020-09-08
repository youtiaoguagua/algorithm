package sword.offer.day2;

import java.util.List;

/**
 * 删除链表中重复的节点
 * @author youtiaoguagua
 * @date 2020/9/8 上午 10:37
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。
 * 样例1
 * 输入：1->2->3->3->3->4->4->5
 * 输出：1->2->5
 * 1 1 1 2 3
 * -1  1   1 2
 */
public class DeleteDuplication {

    public ListNode deleteDuplication2(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = node;
        while (p.next!=null){
            ListNode q = p.next;
            while (q!=null&&p.next.val==q.val){
                q = q.next;
            }

            if (p.next.next==q){
                p = p.next;
            }else {
                p.next = q;
            }
        }
        return  node.next;
    }

    public ListNode deleteDuplication(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode vritual = new ListNode(-1);
        vritual.next = head;
        ListNode pre = vritual;
        ListNode after = head;
        boolean ifMove =false;


        while (after!=null&&after.next!=null){
            while (after.next!=null&&after.next.val==after.val){
                after = after.next;
                ifMove = true;
            }
            if (ifMove){
                after = after.next;
                pre.next = after;
            }else {
                pre = after;
                after = after.next;
            }
            ifMove = false;
        }
        return vritual.next;
    }

    public static void main(String[] args) {
        DeleteDuplication deleteDuplication = new DeleteDuplication();
        ListNode root = new ListNode(4);
        root.next = new ListNode(4);
        root.next.next = new ListNode(4);
        ListNode listNode = deleteDuplication.deleteDuplication2(root);
    }

  static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
