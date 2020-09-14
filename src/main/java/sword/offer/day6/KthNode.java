package sword.offer.day6;

import javax.swing.tree.TreeNode;

/**
 * 二叉搜索树的第k个结点
 * @author youtiaoguagua
 * @date 2020/9/14 10:14
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 你可以假设树和k都存在，并且1≤k≤树的总结点数。
 * 样例
 * 输入：root = [2, 1, 3, null, null, null, null] ，k = 3
 *     2
 *    / \
 *   1   3
 * 输出：3
 */
public class KthNode {

    private int k;
    TreeNode res = null;

    public TreeNode kthNode(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        dfs(root.left);
        k = k-1;
        if (k==0){
            res = root;
            return;
        }
        dfs(root.right);
    }


    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
