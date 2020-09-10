package sword.offer.day3;

/**
 * 二叉树的镜像
 * @author youtiaoguagua
 * @date 2020/9/9 下午 8:42
 * 输入一个二叉树，将它变换为它的镜像。
 * 样例
 * 输入树：
 *       8
 *      / \
 *     6  10
 *    / \ / \
 *   5  7 9 11
 *  [8,6,10,5,7,9,11,null,null,null,null,null,null,null,null]
 * 输出树：
 *       8
 *      / \
 *     10  6
 *    / \ / \
 *   11 9 7  5
 *  [8,10,6,11,9,7,5,null,null,null,null,null,null,null,null]
 */
public class Mirror {
    public void mirror(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        dfs(root.left);
        dfs(root.right);
    }


    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
