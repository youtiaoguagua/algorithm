package sword.offer.day6;

/**
 * 二叉树的深度
 * @author youtiaoguagua
 * @date 2020/9/14 10:53
 * 输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 样例
 * 输入：二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]如下图所示：
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 * 输出：3
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        int dfs = dfs(root, 0);
        return dfs;
    }

    private int dfs(TreeNode root,int deep) {
        if (root == null) {
            return deep;
        }
        int dfs = dfs(root.left, deep + 1);
        int dfs1 = dfs(root.right, deep + 1);
        int max = Math.max(dfs, dfs1);
        return max;
    }


    static public class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
