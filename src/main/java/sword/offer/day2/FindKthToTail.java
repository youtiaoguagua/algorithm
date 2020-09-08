package sword.offer.day2;

/**
 * 链表中倒数第k个节点
 * @author youtiaoguagua
 * @date 2020/9/9 上午 12:43
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 注意：
 * k >= 0;
 * 如果k大于链表长度，则返回 NULL;
 * 样例
 * 输入：链表：1->2->3->4->5 ，k=2
 * 输出：4
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode pListHead, int k) {
        int len = 0;
        ListNode tmp = pListHead;
        while (tmp!=null){
            tmp = tmp.next;
            len++;
        }
        if (k>len){
            return null;
        }

        tmp = pListHead;
        for (int i = 0; i < len-k; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
