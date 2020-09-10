package sword.offer.day3;

/**
 * 对称的二叉树
 * @author youtiaoguagua
 * @date 2020/9/9 20:52
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 样例
 * 如下图所示二叉树[1,2,2,3,4,4,3,null,null,null,null,null,null,null,null]为对称二叉树：
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 如下图所示二叉树[1,2,2,null,4,4,3,null,null,null,null,null,null]不是对称二叉树：
 *     1
 *    / \
 *   2   2
 *    \ / \
 *    4 4  3
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean dfs = dfs(root.left, root.right);
        return dfs;
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left==null&&right==null){
            return true;
        }else if (left==null||right==null){
            return false;
        }

        if (left.val!=right.val){
            return false;
        }
        boolean b = dfs(left.left, right.right) && dfs(left.right, right.left);
        return b;
    }

    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
