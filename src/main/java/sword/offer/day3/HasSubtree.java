package sword.offer.day3;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 * 树的子结构
 * @author youtiaoguagua
 * @date 2020/9/9 下午 7:37
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * 我们规定空树不是任何树的子结构。
 * 样例
 * 树A：
 *      8
 *     / \
 *    8   7
 *   / \
 *  9   2
 *     / \
 *    4   7
 * 树B：
 *    8
 *   / \
 *  9   2
 * 返回 true ,因为B是A的子结构。
 */
public class HasSubtree {
    /**
     * 优化版
     */
    public boolean hasSubtree2(TreeNode root1, TreeNode root2) {
        if (root1==null||root2==null){
            return false;
        }
        if (dfs2(root1,root2)){
            return true;
        }

        return hasSubtree2(root1.left,root2)||hasSubtree2(root1.right,root2);
    }

    private boolean dfs2(TreeNode root1, TreeNode root2) {
        if (root2==null){
            return true;
        }
        if (root1==null||root1.val!=root2.val){
            return false;
        }


        return dfs2(root1.left,root2.left)&&dfs2(root1.right,root2.right);
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root2==null){
            return false;
        }
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        dfs(root1,builder1);
        dfs(root2,builder2);
        boolean contains = builder1.toString().contains(builder2.toString());
        return contains;
    }

    private void dfs(TreeNode root,StringBuilder list) {
        if (root==null){
            return;
        }
        list.append(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
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
