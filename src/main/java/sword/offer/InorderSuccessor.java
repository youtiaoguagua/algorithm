package sword.offer;

/**
 * 二叉树的下一个节点
 * @author youtiaoguagua
 * @date 2020/9/6 下午 9:45
 * 给定一棵二叉树的其中一个节点，请找出中序遍历序列的下一个节点。
 * 注意：
 * 如果给定的节点是中序遍历序列的最后一个，则返回空节点;
 * 二叉树一定不为空，且给定的节点一定不是空节点；
 * 样例
 * 假定二叉树是：[2, 1, 3, null, null, null, null]， 给出的是值等于2的节点。
 * 则应返回值等于3的节点。
 * 解释：该二叉树的结构如下，2的后继节点是3。
 *      3
 *    /   \
 *   9    20
 *  /  \  /  \
 *  5  8  15  7
 * / \
 * 6  4
 * [6,5,4,9,8,3,15,20,7]
 */
public class InorderSuccessor {


    /**
     * 需要分情况讨论：
     * 1.如果一个这个节点有右子节点那么就找循环找右子节点的左子节点到底就是后继节点，比如9，有右子节点，所以下一个节点是8，3有右子节点20，左子节点15，
     * 2.如果一个节点有父节点，并且是父节点的左子节点，那么父节点就是后继节点
     * 3.如果一个节点有父节点，并且是父节点的右子节点，父节点是根节点左儿子，那么父节点的父节点到底就是后继节点
     * 4.（2）（3）可以放一起考虑
     */
    public TreeNode inorderSuccessor(TreeNode p) {
        //第一种情况
        if (p.right!=null){
            p = p.right;
            while (p.left!=null){
                p = p.left;
            }
            return p;
        }
        //第二种情况
        while (p.father!=null&&p==p.father.right){
            p = p.father;
        }
        return p.father;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode father;

        TreeNode(int x) {
            val = x;
        }
    }
}
