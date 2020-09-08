package sword.offer.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 链表中环的入口结点
 * @author youtiaoguagua
 * @date 2020/9/9 上午 12:55
 * 给定一个链表，若其中包含环，则输出环的入口节点。
 * 若其中不包含环，则输出null。
 * 给定如上所示的链表：
 * [1, 2, 3, 4, 5, 6]
 * 2是第几个节点也就是也就是值为3的节点，输出值为3的节点；
 * 注意，这里的2表示编号是2的节点，节点编号从0开始。所以编号是2的节点就是val等于3的节点。
 * 则输出环的入口节点3.
 */
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode head) {
        if (head==null){
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp.next!=null){
            list.add(tmp);
            if (list.contains(tmp.next)){
                return tmp.next;
            }
            tmp = tmp.next;
        }
        return null;
    }

    /**
     * 优化版
     * 两个指针，一个指针走两步，一个走一步，当两个指针相遇后，
     * 走一步的指针移动到开始head位置，然后每次走一步，走两步的指针也每次走一步，
     * 直到相遇，这次相遇的点就是入口点
     */
    public ListNode entryNodeOfLoop2(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (first!=null&&second!=null){
            first = first.next;
            second = second.next;
            if (second!=null){
                second = second.next;
            }
            if (first==second){
                first = head;

                while (first!=second){
                    first = first.next;
                    second = second.next;
                }
                return second;
            }

        }
        return null;

    }

    public static void main(String[] args) {
        EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();
        ListNode root = new ListNode(4);
        ListNode root1 = new ListNode(3);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(5);
        ListNode root4 = new ListNode(1);
        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root4;


        ListNode listNode = entryNodeOfLoop.entryNodeOfLoop2(root);
        System.out.println(listNode.val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
