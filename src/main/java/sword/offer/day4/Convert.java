package sword.offer.day4;

/**
 * 二叉搜索树与双向链表
 * @author youtiaoguagua
 * @date 2020/9/11 13:02
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 注意：
 * 需要返回双向链表最左侧的节点。
 * 例如，输入下图中左边的二叉搜索树，则输出右边的排序双向链表。
 * https://www.acwing.com/media/article/image/2018/12/02/19_23bee494f5-QQ%E6%88%AA%E5%9B%BE20181202052830.png
 */
public class Convert {
    public TreeNode convert(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode[] dfs = dfs(root);
        return dfs[0];
    }

    private TreeNode[] dfs(TreeNode node) {
        if (node.left==null&&node.right==null){
            return new TreeNode[]{node,node};
        }
        if (node.left!=null&&node.right!=null){
            TreeNode[] left = dfs(node.left);
            TreeNode[] right = dfs(node.right);
            left[1].right = node;
            node.left = left[1];
            node.right = right[0];
            right[0].left = node;
            return new TreeNode[]{left[0],right[1]};
        }

        if (node.left!=null){
            TreeNode[] left = dfs(node.left);
            left[1].right = node;
            node.left = left[1];
            return new TreeNode[]{left[0],node};
        }

        if (node.right!=null){
            TreeNode[] right = dfs(node.right);
            node.right = right[0];
            right[0].left = node;
            return new TreeNode[]{node,right[1]};
        }
        return new TreeNode[0];
    }

    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
