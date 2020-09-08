package sword.offer.day2;

/**
 * 在O(1)时间删除链表结点
 * @author youtiaoguagua
 * @date 2020/9/8 上午 10:24
 * 给定单向链表的一个节点指针，定义一个函数在O(1)时间删除该结点。
 * 假设链表一定存在，并且该节点一定不是尾节点。
 * 样例
 * 输入：链表 1->4->6->8
 * 删掉节点：第2个节点即6（头节点为第0个节点）
 * 输出：新链表 1->4->8
 */
public class DeleteNode {

    /**
     * 没有给出前驱节点
     * 将当前节点的值等于下一个节点的值
     * 将当前节点指向下一个节点的下一个节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
