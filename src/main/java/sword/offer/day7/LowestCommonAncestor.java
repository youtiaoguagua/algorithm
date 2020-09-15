package sword.offer.day7;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 *树中两个结点的最低公共祖先
 * @author youtiaoguagua
 * @date 2020/9/16 01:39
 * 给出一个二叉树，输入两个树节点，求它们的最低公共祖先。
 * 一个树节点的祖先节点包括它本身。
 * 注意：
 * 输入的二叉树不为空；
 * 输入的两个节点一定不为空，且是二叉树中的节点；
 * 样例
 * 二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]如下图所示：
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 * 1. 如果输入的树节点为2和12，则输出的最低公共祖先为树节点8。
 * 2. 如果输入的树节点为2和6，则输出的最低公共祖先为树节点2。
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root==p||root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        if (left!=null){
            return left;
        }else {
            return right;
        }
    }


    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      public TreeNode(int x) { val = x; }
  }
}
