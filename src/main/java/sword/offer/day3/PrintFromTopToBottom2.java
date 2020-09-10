package sword.offer.day3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分行从上往下打印二叉树
 *
 * @author youtiaoguagua
 * @date 2020/9/10 10:22
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, null, 4, null, null, null]
 * 8
 * / \
 * 12  2
 * /
 * 6
 * /
 * 4
 * 输出：[[8], [12, 2], [6], [4]]
 */
public class PrintFromTopToBottom2 {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> lin = new LinkedList<>();
        if (root == null) {
            return list;
        }

        lin.add(root);
        while (!lin.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (!lin.isEmpty()) {
                TreeNode pop = lin.pop();
                list1.add(pop.val);
                tmp.add(pop);
            }
            list.add(list1);

            for (TreeNode treeNode : tmp) {
                if (treeNode.left != null) {
                    lin.add(treeNode.left);

                }

                if (treeNode.right != null) {
                    lin.add(treeNode.right);
                }
            }

        }
        return list;
    }

    /**
     * 优化版
     */
    public List<List<Integer>> printFromTopToBottom2(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        ArrayList<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode pop = queue.pop();
            if (pop==null){
                if (tmp.isEmpty()){
                    break;
                }
                list.add((List<Integer>) tmp.clone());
                queue.add(null);
               tmp.clear();
            }else {
                tmp.add(pop.val);
                if (pop.left!=null){

                queue.add(pop.left);
                }

                if (pop.right!=null){

                queue.add(pop.right);
                }
            }

        }
        return list;
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
