package sword.offer.day3;

/**
 * 合并两个排序的链表
 *
 * @author youtiaoguagua
 * @date 2020/9/9 下午 4:26
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * 样例
 * 输入：1->3->5 , 2->4->5
 * 输出：1->2->3->4->5->5
 */
public class Merge {
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }
        ListNode cur1 = l1, cur2 = l2;
        ListNode node = new ListNode(-1), cur = node;
        while (cur1 != null && cur2 != null) {
            if (cur2 == null || cur1.val <= cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }

            if (cur1 == null || cur2.val <= cur1.val) {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }

        }

        while (cur1 != null) {
            cur.next = cur1;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        //[4, 8, 15, 19, 20, 23, 34]
        //[6, 12, 13, 15, 18, 18, 27]
        ListNode l1 = new ListNode(4).setNext(new ListNode(8)
                .setNext(new ListNode(15).setNext(new ListNode(19)
                        .setNext(new ListNode(20).setNext(new ListNode(23).setNext(new ListNode(34)))))));
        ListNode l2 = new ListNode(6).setNext(new ListNode(12)
                .setNext(new ListNode(13).setNext(new ListNode(15)
                        .setNext(new ListNode(18).setNext(new ListNode(18).setNext(new ListNode(27)))))));
        merge.merge(l1, l2);
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }
    }
}
