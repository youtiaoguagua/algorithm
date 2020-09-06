package sword.offer;

import java.util.HashMap;

/**
 * 重建二叉树
 * @author youtiaoguagua
 * @date 2020/9/6 下午 6:35
 * 输入一棵二叉树前序遍历和中序遍历的结果，请重建该二叉树。
 * 注意:
 * 二叉树中每个节点的值都互不相同；
 * 输入的前序遍历和中序遍历一定合法；
 * 样例
 * 给定：
 * 前序遍历是：[3, 9,5,6,4,8, 20, 15, 7]
 * 中序遍历是：[6,5,4,9,8,3,15,20,7]
 * 返回：[3, 9, 20, null, null, 15, 7, null, null, null, null]
 * 返回的二叉树如下所示：
 *      3
 *    /   \
 *   9    20
 *  /  \  /  \
 *  5  8  15  7
 * / \
 * 6  4
 */
public class BuildTree {

    HashMap<Integer, Integer> map = new HashMap<>();
    private int[] preorder;
    private int[] inorder;

    /**
     * 当root节点是前序遍历的第一个节点，那么在中序遍历中那个节点的左
     * 边就是左子树的节点数，右边就是右子树的节点数
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = dfs(0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode dfs(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        int tmp = map.get(preorder[preLeft]);
        //前序遍历是：[3, 9,5,6,4,8, 20, 15, 7]
        //中序遍历是：[6,5,4,9,8,3,15,20,7]
        TreeNode left = dfs(preLeft + 1, preLeft + tmp - inLeft, inLeft, tmp - 1);
        TreeNode right = dfs(preLeft + tmp - inLeft + 1, preRight, tmp + 1, inRight);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
