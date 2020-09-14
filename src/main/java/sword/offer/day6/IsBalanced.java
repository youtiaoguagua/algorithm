package sword.offer.day6;

/**
 * 平衡二叉树
 *
 * @author youtiaoguagua
 * @date 2020/9/14 11:01
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 注意：
 * 规定空树也是一棵平衡二叉树。
 * 样例
 * 输入：二叉树[5,7,11,null,null,12,9,null,null,null,null]如下所示，
 *    5
 *   / \
 *  7  11
 *  /  \
 * 12   9
 * 输出：true
 */
public class IsBalanced {
    private TreeNode treeNode;
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        treeNode = root;
        int dfs = dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        int dfs = dfs(root.left, deep + 1);
        int dfs1 = dfs(root.right, deep + 1);
        int max=0;
        if (Math.abs(dfs-dfs1) > 1){
            res =false;
        }
        max = Math.max(dfs, dfs1);
        return max;
    }


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
