package sword.offer.day5;

import java.util.HashSet;

/**
 * 两个链表的第一个公共结点
 * @author youtiaoguagua
 * @date 2020/9/14 00:27
 * 输入两个链表，找出它们的第一个公共结点。
 * 当不存在公共节点时，返回空节点。
 * 样例
 * 给出两个链表如下所示：
 * A：        a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 输出第一个公共节点c1
 */
public class FindFirstCommonNode {

    /**
     * 优化版
     */
    public ListNode findFirstCommonNode2(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (q!=p){
            if (p!=null){
                p = p.next;
            }else {
                p = headB;
            }

            if (q != null) {
                q = q.next;
            }else {
                q = headA;
            }
        }
        return p;
    }


    public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

   static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
